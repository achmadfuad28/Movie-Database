package com.achmadfuad.moviedatabase.module

import com.achmadfuad.data.room.AppDatabase
import com.achmadfuad.domain.repository.MovieListLocalSource
import com.achmadfuad.data.room.MovieListLocalSourceImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val roomModule = module {

    single { AppDatabase.buildDatabase(androidContext()) }
    single { get<AppDatabase>().movieDao() }
    factory<MovieListLocalSource> {
        MovieListLocalSourceImpl(movieDao = get(), movieDetailToEntityMapper = get(), movieEntityToMoviesMapper = get())
    }

}