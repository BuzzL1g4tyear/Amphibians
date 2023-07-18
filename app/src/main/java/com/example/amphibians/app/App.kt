package com.example.amphibians.app

import android.app.Application
import com.example.amphibians.ui.di.appModule
import com.example.amphibians.ui.di.dataModule
import com.example.amphibians.ui.di.domainModule
import org.koin.android.ext.android.get
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(level = Level.DEBUG)
            androidContext(this@App)
            modules(
                listOf(
                    appModule, dataModule, domainModule
                )
            )
        }
    }
}