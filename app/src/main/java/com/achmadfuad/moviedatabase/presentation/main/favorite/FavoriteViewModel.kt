package com.achmadfuad.moviedatabase.presentation.main.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.achmadfuad.core.data.Resource
import com.achmadfuad.domain.model.Movie
import com.achmadfuad.domain.usecase.GetFavoriteMovieUseCase
import kotlinx.coroutines.launch

class FavoriteViewModel(
    private val getFavoriteMovieUseCase: GetFavoriteMovieUseCase
) : ViewModel() {

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