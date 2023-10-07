package com.achmadfuad.domain.repository

import com.achmadfuad.core.data.Resource
import com.achmadfuad.domain.model.Movie
import kotlinx.coroutines.flow.Flow


interface MovieListLocalSource {
    suspend fun getFavoriteMovieList(): Flow<Resource<List<Movie>>>
    suspend fun addMovieToFavorite(movie: Movie)
}
