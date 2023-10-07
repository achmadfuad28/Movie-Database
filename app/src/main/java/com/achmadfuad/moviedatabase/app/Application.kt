package com.achmadfuad.moviedatabase.app

import android.app.Application
import com.achmadfuad.moviedatabase.module.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext
import org.koin.core.logger.Level

class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        GlobalContext.startKoin {
            androidContext(this@Application)
            androidLogger(Level.NONE)
            modules(appModule)
        }
    }
}