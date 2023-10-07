package com.achmadfuad.data.model

import com.google.gson.annotations.SerializedName

data class MovieDetailResponse (
    @SerializedName("imdbID")
    val id: String = "",
    @SerializedName("Poster")
    val poster: String,
    @SerializedName("Title")
    val name: String,
    @SerializedName("Year")
    val year: String,
    @SerializedName("Rated")
    val rated: String,
    @SerializedName("Released")
    val released: String,
    @SerializedName("Runtime")
    val runtime: String,
    @SerializedName("Genre")
    val genre: String,
    @SerializedName("Director")
    val director: String,
    @SerializedName("Writer")
    val writer: String,
    @SerializedName("Actors")
    val actors: String,
    @SerializedName("Type")
    val type: String,
    @SerializedName("Plot")
    val plot: String
)