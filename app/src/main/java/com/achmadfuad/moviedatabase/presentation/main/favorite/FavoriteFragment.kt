package com.achmadfuad.moviedatabase.presentation.main.favorite

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.achmadfuad.core.BaseView
import com.achmadfuad.core.data.Resource
import com.achmadfuad.core.extension.navigateTo
import com.achmadfuad.core.extension.visible
import com.achmadfuad.moviedatabase.R
import com.achmadfuad.moviedatabase.databinding.FragmentFavoriteBinding
import com.achmadfuad.moviedatabase.presentation.utils.delegate.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteFragment : Fragment(R.layout.fragment_favorite), BaseView {

    private val binding by viewBinding(FragmentFavoriteBinding::bind)
    private val viewModel: FavoriteViewModel by viewModel()

    private val favoriteAdapter by lazy {
        FavoriteMovieAdapter(onClick = { id ->
            navigateToDetailFragment(id)
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getFavoriteMovies()
        setupAdapter()
        observeMovieResponse()
    }

    private fun navigateToDetailFragment(id: String) {
        val direction = FavoriteFragmentDirections.movieDetailAction(id)
        navigateTo(direction)
    }

    private fun setupAdapter() {
        binding.rvMovies.run {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = favoriteAdapter
        }
    }

    private fun observeMovieResponse() {
        observeData(viewModel.favoritesResponse) { result ->
            result?.let {
                when (it) {
                    is Resource.Success -> {
                        if (it.model.isNullOrEmpty()) {
                            binding.tvMessage.visible()
                            return@observeData
                        }
                        favoriteAdapter.submitList(it.model)
                    }
                    else -> Unit
                }
            }
        }
    }
}