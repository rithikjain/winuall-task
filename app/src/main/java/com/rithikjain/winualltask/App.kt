package com.rithikjain.winualltask

import android.app.Application
import com.rithikjain.winualltask.di.appComponents
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(appComponents)
        }
    }
}