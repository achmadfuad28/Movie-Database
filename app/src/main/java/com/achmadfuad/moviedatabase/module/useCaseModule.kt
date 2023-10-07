package com.achmadfuad.moviedatabase.module


import com.achmadfuad.domain.usecase.GetFavoriteMovieUseCase
import com.achmadfuad.domain.usecase.MovieDetailUseCase
import com.achmadfuad.domain.usecase.MoviesUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { MoviesUseCase(get()) }
    single { MovieDetailUseCase(get()) }
    single { GetFavoriteMovieUseCase(get()) }
}