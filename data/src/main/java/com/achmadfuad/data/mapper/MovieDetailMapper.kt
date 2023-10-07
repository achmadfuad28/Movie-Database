package com.achmadfuad.data.mapper

import com.achmadfuad.core.network.Mapper
import com.achmadfuad.data.model.MovieDetailResponse
import com.achmadfuad.domain.model.Movie

class MovieDetailMapper :
    Mapper<MovieDetailResponse, Movie> {

    override fun to(t: MovieDetailResponse): Movie {
        return with(t) {
            Movie(
                imdbID = id,
                poster = poster,
                title = name,
                year = year,
                type = type,
                rated = rated,
                released = released,
                runtime = "Durasi : $runtime",
                genre = genre,
                director = "Sutradara : $director",
                writer = "Penulis : $writer",
                actor = "Aktor : $actors",
                plot = "Sinopsis : $plot"
            )
        }
    }
}
