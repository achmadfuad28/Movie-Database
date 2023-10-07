package com.achmadfuad.domain.usecase

import androidx.paging.PagingData
import com.achmadfuad.core.network.PagingFlowUseCase
import com.achmadfuad.domain.model.Movie
import com.achmadfuad.domain.model.MovieParam
import com.achmadfuad.domain.repository.MovieRepository

import kotlinx.coroutines.flow.Flow

class MoviesUseCase(private val repo: MovieRepository) : PagingFlowUseCase<MovieParam, PagingData<Movie>>() {
    override suspend fun execute(param: MovieParam?): Flow<PagingData<Movie>> {
        return repo.getMovies(param?.sKey.orEmpty(), param?.type)
    }
}