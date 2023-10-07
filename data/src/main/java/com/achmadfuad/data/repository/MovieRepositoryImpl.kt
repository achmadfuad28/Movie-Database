package com.achmadfuad.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.achmadfuad.core.data.Resource
import com.achmadfuad.core.extension.catchError
import com.achmadfuad.core.extension.mapTo
import com.achmadfuad.core.extension.onProgress
import com.achmadfuad.data.MoviesPagingSource
import com.achmadfuad.data.mapper.MovieDetailMapper
import com.achmadfuad.data.mapper.MovieMapper
import com.achmadfuad.data.service.MovieService
import com.achmadfuad.domain.model.Movie
import com.achmadfuad.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class MovieRepositoryImpl(
    private val service: MovieService,
    private val mapper: MovieMapper,
    private val movieDetailMapper: MovieDetailMapper
) : MovieRepository {

    override suspend fun getMovies(sKey: String, type: String?): Flow<PagingData<Movie>> {
        val moviePager = Pager(
            config = PagingConfig(pageSize = 10, enablePlaceholders = false),
            pagingSourceFactory = { MoviesPagingSource(repository = service, sKey, type) }
        ).flow

        return moviePager.map { pagingData ->
            pagingData.map {
                mapper.toMovie(it)
            }
        }
    }

    override suspend fun getMovieDetail(movieId: String): Flow<Resource<Movie>> {
        return flow {
            val response = service.getMovieDetail("json", movieId)
            emit(response.mapTo(movieDetailMapper))
        }.onProgress().catchError()
    }
}