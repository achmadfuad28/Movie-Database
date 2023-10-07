package com.achmadfuad.data.model.room_entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_detail_entity")
data class MovieDetailEntity(
    @PrimaryKey
    val id: String,
    var poster: String? = "",
    var name: String? = "",
    var year: String? = "",
    var rated: String? = "",
    var released: String? = "",
    var runtime: String? = "",
    var genre: String? = "",
    var director: String? = "",
    var writer: String? = "",
    var actors: String? = "",
    var type: String? = "",
    var plot: String? = ""
)