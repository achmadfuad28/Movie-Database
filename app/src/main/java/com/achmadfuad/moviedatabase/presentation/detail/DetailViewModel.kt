package com.achmadfuad.moviedatabase.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.achmadfuad.core.data.Resource
import com.achmadfuad.domain.repository.MovieListLocalSource
import com.achmadfuad.domain.model.Movie
import com.achmadfuad.domain.usecase.GetFavoriteMovieUseCase
import com.achmadfuad.domain.usecase.MovieDetailUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailViewModel(
    private val movieDetailUseCase: MovieDetailUseCase,
    private val localSource: MovieListLocalSource,
    private val getFavoriteMovieUseCase: GetFavoriteMovieUseCase
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

    fun addToFavorite(movie: Movie) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                localSource.addMovieToFavorite(movie)
            }
        }
    }


    private val _favoritesResponse = MutableLiveData<Resource<List<Movie>>>()
    val favoritesResponse: LiveData<Resource<List<Movie>>> = _favoritesResponse

    fun getFavoriteMovies() {
        viewModelScope.launch {
            getFavoriteMovieUseCase().collect {
                _favoritesResponse.value = it
            }
        }
    }
}