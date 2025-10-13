package com.bagmanovam.nasa_planets

import android.app.Application
import com.bagmanovam.nasa_planets.di.appModule
import com.bagmanovam.nasa_planets.di.dataModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            androidLogger()
            modules(appModule, dataModule)
        }
    }
}