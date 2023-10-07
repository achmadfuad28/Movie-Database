package com.achmadfuad.moviedatabase.presentation.main.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.achmadfuad.core.BaseView
import com.achmadfuad.moviedatabase.R
import com.achmadfuad.moviedatabase.databinding.FragmentHomeBinding
import com.achmadfuad.moviedatabase.presentation.utils.delegate.viewBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(R.layout.fragment_home), BaseView {

    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val viewModel: HomeViewModel by viewModel()

    private val latestMoviesAdapter by lazy {
        MovieAdapter(onClick = { _ ->

        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getMovies()
        setupListener()
        setupAdapter()
        observeMovieResponse()
    }

    private fun setupListener() {

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