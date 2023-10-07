package com.achmadfuad.data.mapper

import com.achmadfuad.core.network.Mapper
import com.achmadfuad.data.model.MovieDetailResponse
import com.achmadfuad.data.model.room_entity.MovieDetailEntity
import com.achmadfuad.domain.model.Movie

class MovieDetailtoEntityMapper :
    Mapper<Movie, MovieDetailEntity> {

    override fun to(t: Movie): MovieDetailEntity {
        return with(t) {
            MovieDetailEntity(
                id = imdbID,
                poster = poster,
                name = title,
                year = year,
                type = type,
                rated = rated,
                released = released,
                runtime = runtime,
                genre = genre,
                director = director,
                writer = writer,
                actors = actor,
                plot = plot
            )
        }
    }
}
