package com.achmadfuad.data.room

import com.achmadfuad.core.data.Resource
import com.achmadfuad.core.extension.catchError
import com.achmadfuad.core.extension.mapTo
import com.achmadfuad.core.extension.mappingTo
import com.achmadfuad.core.extension.onProgress
import com.achmadfuad.data.mapper.MovieDetailtoEntityMapper
import com.achmadfuad.data.mapper.MovieEntityToMoviesMapper
import com.achmadfuad.data.model.room_entity.MovieDao
import com.achmadfuad.domain.model.Movie
import com.achmadfuad.domain.repository.MovieListLocalSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MovieListLocalSourceImpl(
    private val movieDao: MovieDao,
    private val movieDetailToEntityMapper: MovieDetailtoEntityMapper,
    private val movieEntityToMoviesMapper: MovieEntityToMoviesMapper
) : MovieListLocalSource {
    override suspend fun getFavoriteMovieList(): Flow<Resource<List<Movie>>> {
        return flow {
            val response = movieDao.getAllMovie()
            emit(response.mapTo(movieEntityToMoviesMapper))
        }.onProgress().catchError()
    }

    override suspend fun addMovieToFavorite(movie: Movie) {
        movieDao.insert(movie.mappingTo(movieDetailToEntityMapper))
    }
}
