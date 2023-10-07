package com.achmadfuad.moviedatabase.presentation.main.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.achmadfuad.domain.model.Movie
import com.achmadfuad.domain.model.MovieParam
import com.achmadfuad.domain.usecase.MovieUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(
    private val movieUseCase: MovieUseCase,
    ) : ViewModel() {
    
    private val _latestMoviesResponse = MutableLiveData<PagingData<Movie>>()
    val latestMoviesResponse: LiveData<PagingData<Movie>> = _latestMoviesResponse
    private val _latestSeriesResponse = MutableLiveData<PagingData<Movie>>()
    val latestSeriesResponse: LiveData<PagingData<Movie>> = _latestSeriesResponse
    private val _trendingResponse = MutableLiveData<PagingData<Movie>>()
    val trendingResponse: LiveData<PagingData<Movie>> = _trendingResponse

    val loading = MutableLiveData(false)

    fun getMovies() {
        viewModelScope.launch {
            loading.value = true
            withContext(Dispatchers.IO) {
                movieUseCase(MovieParam("Avengers", "movie")).cachedIn(viewModelScope)
            }.collectLatest {
                _latestMoviesResponse.value = it
                loading.value = false
            }
        }
    }
}