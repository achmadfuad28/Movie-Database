package com.achmadfuad.domain.usecase

import com.achmadfuad.core.data.Resource
import com.achmadfuad.core.network.FlowUseCase
import com.achmadfuad.domain.model.Movie
import com.achmadfuad.domain.repository.MovieListLocalSource
import kotlinx.coroutines.flow.Flow

class GetFavoriteMovieUseCase(private val localSource: MovieListLocalSource) :
    FlowUseCase<String, List<Movie>>() {
    override suspend fun execute(parameters: String?): Flow<Resource<List<Movie>>> {
        return localSource.getFavoriteMovieList()
    }
}