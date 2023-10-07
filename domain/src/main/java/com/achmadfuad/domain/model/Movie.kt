package com.achmadfuad.domain.model

data class Movie(
    val imdbID: String,
    val poster: String?,
    val title: String,
    val type: String,
    val year: String,
    val rated: String? = "",
    val released: String? = "",
    val runtime: String? = "",
    val genre: String? = "",
    val director: String? = "",
    val writer: String? = "",
    val actor: String? = "",
    val plot: String? = ""
)
