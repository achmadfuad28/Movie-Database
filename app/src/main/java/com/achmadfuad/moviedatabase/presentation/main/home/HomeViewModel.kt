package com.achmadfuad.moviedatabase.presentation.main.home

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

class HomeViewModel(
    private val movieUseCase: MoviesUseCase
    ) : ViewModel() {
    
    private val _latestMoviesResponse = MutableLiveData<PagingData<Movie>>()
    val latestMoviesResponse: LiveData<PagingData<Movie>> = _latestMoviesResponse

    val loading = MutableLiveData(false)

    fun getMovies() {
        viewModelScope.launch {
            loading.value = true
            withContext(Dispatchers.IO) {
                movieUseCase(MovieParam("Avengers", "")).cachedIn(viewModelScope)
            }.collectLatest {
                _latestMoviesResponse.value = it
                loading.value = false
            }
        }
    }
}