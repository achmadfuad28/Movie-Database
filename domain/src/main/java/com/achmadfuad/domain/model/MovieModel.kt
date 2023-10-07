package com.achmadfuad.domain.model

data class MovieModel(
    val total: Int = 0,
    val next: String = "",
    val movies: List<Movie>
)
