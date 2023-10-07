package com.achmadfuad.moviedatabase.presentation.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.achmadfuad.core.BaseView
import com.achmadfuad.core.data.Resource
import com.achmadfuad.core.extension.loadImageWithRadius
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

        viewModel.getDetailMovie(detailArgs.id)
        observeDetailMovie()
    }

    private fun observeDetailMovie() {
        viewModel.movieDetailResponse.observe(this) { result ->
            result?.let {
                when (it) {
                    is Resource.Success -> {
                        binding.apply {
                            ivPoster.loadImageWithRadius(it.model?.poster)
                            tvTitle.text = it.model?.title
                            tvYear.text = it.model?.year
                            tvType.text = it.model?.type
                            tvRated.text = it.model?.rated
                            tvRelease.text = it.model?.released
                            tvRuntime.text = it.model?.runtime
                            tvGenre.text = it.model?.genre
                            tvDirector.text = it.model?.director
                            tvWriter.text = it.model?.writer
                            tvActor.text = it.model?.actor
                            tvPlot.text = it.model?.plot
                        }
                    }

                    else -> Unit
                }
            }
        }
    }
}