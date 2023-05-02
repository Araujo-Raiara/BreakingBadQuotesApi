package com.example.breakingbadquotes

import android.app.Application
import com.example.breakingbadquotes.ui.di.baseNetwork
import com.example.breakingbadquotes.ui.di.baseRepository
import com.example.breakingbadquotes.ui.di.baseViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AppApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@AppApplication)

            modules(listOf(baseNetwork, baseRepository, baseViewModel))
        }
    }
}