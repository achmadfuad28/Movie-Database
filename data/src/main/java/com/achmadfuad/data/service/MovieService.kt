package com.achmadfuad.data.service

import com.achmadfuad.data.model.MovieDetailResponse
import com.achmadfuad.data.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("/")
    suspend fun getMovie(@Query("s") s: String,
                         @Query("type") type: String?,
                         @Query("r") r: String,
                         @Query("page") page: Int): MovieResponse


    @GET("/")
    suspend fun getMovieDetail(@Query("r") r: String,
                               @Query("i") i: String) : MovieDetailResponse
}
