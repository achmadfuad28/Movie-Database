package com.achmadfuad.data.model

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("count", alternate = ["total_results"])
    val total: Int = 0,
    @SerializedName("next")
    val next: String = "",
    @SerializedName("Search")
    var results: List<MovieResponseItem>
)
