package com.achmadfuad.domain.usecase

import com.achmadfuad.core.data.Resource
import com.achmadfuad.core.network.FlowUseCase
import com.achmadfuad.domain.model.Movie
import com.achmadfuad.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class MovieDetailUseCase (private val repo: MovieRepository) : FlowUseCase<String, Movie>() {
    override suspend fun execute(parameters: String?): Flow<Resource<Movie>> {
        return repo.getMovieDetail(parameters.orEmpty())
    }
}