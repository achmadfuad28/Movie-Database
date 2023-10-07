package com.achmadfuad.moviedatabase.presentation.detail

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.achmadfuad.core.BaseView
import com.achmadfuad.core.data.Resource
import com.achmadfuad.core.extension.loadImageWithRadius
import com.achmadfuad.domain.model.Movie
import com.achmadfuad.moviedatabase.R
import com.achmadfuad.moviedatabase.databinding.FragmentDetailBinding
import com.achmadfuad.moviedatabase.presentation.utils.delegate.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : Fragment(R.layout.fragment_detail), BaseView {
    private val binding by viewBinding(FragmentDetailBinding::bind)
    private val viewModel: DetailViewModel by viewModel()
    private val detailArgs: DetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getFavoriteMovies()
        viewModel.getDetailMovie(detailArgs.id)
        observeDetailMovie()
    }

    private fun observeDetailMovie() {
        viewModel.movieDetailResponse.observe(this) { result ->
            result?.let { movie ->
                when (movie) {
                    is Resource.Success -> {
                        binding.apply {
                            ivPoster.loadImageWithRadius(movie.model?.poster)
                            tvTitle.text = movie.model?.title
                            tvYear.text = movie.model?.year
                            tvType.text = movie.model?.type
                            tvRated.text = movie.model?.rated
                            tvRelease.text = movie.model?.released
                            tvRuntime.text = movie.model?.runtime
                            tvGenre.text = movie.model?.genre
                            tvDirector.text = movie.model?.director
                            tvWriter.text = movie.model?.writer
                            tvActor.text = movie.model?.actor
                            tvPlot.text = movie.model?.plot

                            setupListener(movie)
                        }
                    }

                    else -> Unit
                }
            }
        }

        observeData(viewModel.favoritesResponse) { result ->
            result?.let { response ->
                when (response) {
                    is Resource.Success -> {
                        response.model?.let { favoritesMovies ->
                            if (favoritesMovies.any { it.imdbID == detailArgs.id }) {
                                binding.btnAddToFavorite.isClickable = false
                                binding.btnAddToFavorite.isEnabled = false
                            }
                        }
                    }
                    else -> Unit
                }
            }
        }
    }

    private fun setupListener(movie: Resource.Success<Movie>) {

        binding.btnAddToFavorite.setOnClickListener {
            movie.model?.let {
                viewModel.addToFavorite(it)
                Toast.makeText(
                    requireContext(),
                    getString(R.string.message_success_add_to_favorite), Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}