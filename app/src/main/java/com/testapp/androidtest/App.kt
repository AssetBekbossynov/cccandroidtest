package com.testapp.androidtest

import android.app.Application
import com.testapp.androidtest.di.databaseModule
import com.testapp.androidtest.di.repositoryModule
import com.testapp.androidtest.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(databaseModule, repositoryModule, viewModelModule)
        }
    }
}