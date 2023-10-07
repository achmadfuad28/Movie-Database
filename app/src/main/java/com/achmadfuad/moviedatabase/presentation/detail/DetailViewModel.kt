package com.achmadfuad.moviedatabase.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.achmadfuad.core.data.Resource
import com.achmadfuad.domain.model.Movie
import com.achmadfuad.domain.usecase.MovieDetailUseCase
import kotlinx.coroutines.launch

class DetailViewModel(
    private val movieDetailUseCase: MovieDetailUseCase
    ) : ViewModel() {
    private val _movieDetailResponse = MutableLiveData<Resource<Movie>>()
    val movieDetailResponse: LiveData<Resource<Movie>> = _movieDetailResponse


    private val _loading = MutableLiveData<Boolean>()
    val loading = _loading

    fun getDetailMovie(movieId: String) {
        viewModelScope.launch {
            movieDetailUseCase(movieId).collect {
                _movieDetailResponse.value = it
                loading.value = false
            }
        }
    }

}