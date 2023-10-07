package com.achmadfuad.moviedatabase.app

import android.app.Application
import androidx.room.Room
import com.achmadfuad.data.room.AppDatabase
import com.achmadfuad.moviedatabase.module.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext
import org.koin.core.logger.Level

class Application : Application() {
    private var movieDatabase: AppDatabase? = null

    override fun onCreate() {
        super.onCreate()
        initKoin()
        movieDatabase = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "movie_database"
        ).build()
    }

    fun getMovieDatabase(): AppDatabase? {
        return movieDatabase
    }


    private fun initKoin() {
        GlobalContext.startKoin {
            androidContext(this@Application)
            androidLogger(Level.NONE)
            modules(appModule)
        }
    }
}