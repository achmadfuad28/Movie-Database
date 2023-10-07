package com.achmadfuad.data.mapper

import com.achmadfuad.core.network.Mapper
import com.achmadfuad.data.model.room_entity.MovieDetailEntity
import com.achmadfuad.domain.model.Movie

class MovieEntityToMoviesMapper : Mapper<List<MovieDetailEntity>, List<Movie>> {

    override fun to(t: List<MovieDetailEntity>): List<Movie> {
        return t.map { data ->
            Movie(
                imdbID = data.id,
                poster = data.poster,
                title = data.name.orEmpty(),
                year = data.year.orEmpty(),
                type = data.type.orEmpty(),
                rated = data.rated,
                released = data.released,
                runtime = data.runtime,
                genre = data.genre,
                director = data.director,
                writer = data.writer,
                actor = data.actors,
                plot = data.plot
            )
        }
    }
}
