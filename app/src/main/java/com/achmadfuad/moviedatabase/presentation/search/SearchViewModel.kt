package com.achmadfuad.moviedatabase.presentation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.achmadfuad.domain.model.Movie
import com.achmadfuad.domain.model.MovieParam
import com.achmadfuad.domain.usecase.MoviesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SearchViewModel(
    private val movieUseCase: MoviesUseCase
    ) : ViewModel() {
    
    private val _moviesResponse = MutableLiveData<PagingData<Movie>>()
    val moviesResponse: LiveData<PagingData<Movie>> = _moviesResponse

    val loading = MutableLiveData(false)

    fun getMoviesByQuery(query: String) {
        viewModelScope.launch {
            loading.value = true
            withContext(Dispatchers.IO) {
                movieUseCase(MovieParam("avengers $query")).cachedIn(viewModelScope)
            }.collectLatest {
                _moviesResponse.value = it
                loading.value = false
            }
        }
    }
}