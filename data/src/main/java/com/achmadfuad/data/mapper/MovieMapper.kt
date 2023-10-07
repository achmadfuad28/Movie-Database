package com.achmadfuad.data.mapper

import com.achmadfuad.core.network.Mapper
import com.achmadfuad.data.model.MovieResponse
import com.achmadfuad.data.model.MovieResponseItem
import com.achmadfuad.domain.model.Movie
import com.achmadfuad.domain.model.MovieModel

class MovieMapper : Mapper<MovieResponse, MovieModel> {

    override fun to(t: MovieResponse): MovieModel {
        return with(t) {
            MovieModel(
                total = total,
                next = next,
                movies = results.map {
                    Movie(
                        it.imdbID,
                        it.poster,
                        it.name,
                        it.type,
                        it.year
                    )
                }
            )
        }
    }

    fun toMovie(t: MovieResponseItem): Movie {
        return with(t) {
            Movie(
                imdbID,
                poster = poster,
                title = name,
                type = type,
                year = year,
                released = released
            )
        }
    }

}
