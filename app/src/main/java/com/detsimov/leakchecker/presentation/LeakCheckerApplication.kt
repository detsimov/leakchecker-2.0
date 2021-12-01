package com.detsimov.leakchecker.presentation

import android.app.Application
import com.detsimov.leakchecker.data.di.dataModule
import com.detsimov.leakchecker.domain.di.domainModule
import com.detsimov.leakchecker.presentation.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class LeakCheckerApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@LeakCheckerApplication)
            androidLogger()
            modules(dataModule, domainModule, presentationModule)
        }
    }
}