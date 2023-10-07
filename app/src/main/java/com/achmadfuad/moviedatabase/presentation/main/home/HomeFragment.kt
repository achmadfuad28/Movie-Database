package com.achmadfuad.moviedatabase.presentation.main.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.achmadfuad.core.BaseView
import com.achmadfuad.core.extension.navigateTo
import com.achmadfuad.moviedatabase.R
import com.achmadfuad.moviedatabase.databinding.FragmentHomeBinding
import com.achmadfuad.moviedatabase.presentation.utils.delegate.viewBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(R.layout.fragment_home), BaseView {

    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val viewModel: HomeViewModel by viewModel()

    private val latestMoviesAdapter by lazy {
        MovieAdapter(onClick = { id ->
            navigateToDetailFragment(id)

        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getMovies()
        setupAdapter()
        observeMovieResponse()
    }

    private fun navigateToDetailFragment(id: String) {
        val direction = HomeFragmentDirections.movieDetailAction(id)
        navigateTo(direction)
    }

    private fun setupAdapter() {
        binding.rvLatestMovies.run {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = latestMoviesAdapter
        }
    }

    private fun observeMovieResponse() {
        observeData(viewModel.latestMoviesResponse) { result ->
            result?.let {
                lifecycleScope.launch {
                    latestMoviesAdapter.submitData(it)
                }
            }
        }
    }
}