package com.achmadfuad.moviedatabase.module


import com.achmadfuad.domain.usecase.MovieUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { MovieUseCase(get()) }
}