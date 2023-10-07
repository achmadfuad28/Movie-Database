package com.achmadfuad.data.module

import com.achmadfuad.data.repository.MovieRepositoryImpl
import com.achmadfuad.domain.repository.MovieRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<MovieRepository> { MovieRepositoryImpl(service = get(), mapper = get()) }
}