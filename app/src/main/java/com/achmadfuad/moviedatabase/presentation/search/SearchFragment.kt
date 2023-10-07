package com.achmadfuad.moviedatabase.presentation.search

import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.achmadfuad.core.BaseView
import com.achmadfuad.core.extension.ViewExt
import com.achmadfuad.core.extension.navigateBack
import com.achmadfuad.core.extension.navigateTo
import com.achmadfuad.moviedatabase.R
import com.achmadfuad.moviedatabase.databinding.FragmentSearchBinding
import com.achmadfuad.moviedatabase.presentation.adapter.MovieAdapter
import com.achmadfuad.moviedatabase.presentation.utils.delegate.viewBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : Fragment(R.layout.fragment_search), BaseView {

    private val binding by viewBinding(FragmentSearchBinding::bind)
    private val viewModel: SearchViewModel by viewModel()

    private val moviesAdapter by lazy {
        MovieAdapter(onClick = { id ->
            navigateToDetailFragment(id)
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListener()
        setupAdapter()
        observeMovieResponse()
    }

    private fun setupListener() {
        binding.etSearch.setOnEditorActionListener { textView, i, _ ->
            if (i == EditorInfo.IME_ACTION_SEARCH) {
                viewModel.getMoviesByQuery(textView.text.toString())
                ViewExt.hideKeyboard(requireContext(), binding.etSearch)
                return@setOnEditorActionListener true
            }
            return@setOnEditorActionListener false
        }
        binding.ivBack.setOnClickListener {
            navigateBack()
        }
    }

    private fun navigateToDetailFragment(id: String) {
        val direction = SearchFragmentDirections.movieDetailAction(id)
        navigateTo(direction)
    }

    private fun setupAdapter() {
        binding.rvMovies.run {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = moviesAdapter
            moviesAdapter.addLoadStateListener { loadState ->
                if (loadState.refresh is LoadState.Error) {
                    Toast.makeText(requireContext(), resources.getString(R.string.message_empty_search_data), Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun observeMovieResponse() {
        observeData(viewModel.moviesResponse) { result ->
            result?.let {
                lifecycleScope.launch {
                    moviesAdapter.submitData(it)
                }
            }
        }
    }
}