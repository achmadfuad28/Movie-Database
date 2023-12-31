package com.achmadfuad.domain.repository

import androidx.paging.PagingData
import com.achmadfuad.core.data.Resource
import com.achmadfuad.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun getMovies(sKey: String, type: String?): Flow<PagingData<Movie>>

    suspend fun getMovieDetail(i: String): Flow<Resource<Movie>>

}