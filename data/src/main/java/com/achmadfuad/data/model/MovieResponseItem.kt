package com.achmadfuad.data.model

import com.google.gson.annotations.SerializedName

data class MovieResponseItem(
    @SerializedName("imdbID")
    val imdbID: String,
    @SerializedName("Title")
    val name: String,
    @SerializedName("Year")
    val year: String,
    @SerializedName("released")
    val released: String,
    @SerializedName("Poster")
    val poster: String,
    @SerializedName("Type")
    val type: String
)
