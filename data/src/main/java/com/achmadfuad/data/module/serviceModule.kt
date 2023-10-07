package com.achmadfuad.data.module

import com.achmadfuad.data.service.MovieService
import org.koin.dsl.module
import retrofit2.Retrofit

val serviceModule = module {
    factory { get<Retrofit>().create(MovieService::class.java) }
}