package com.example.theair.application

import android.app.Application
import com.example.theair.presentation.di.networkModule
import com.example.theair.presentation.di.repositoryModule
import com.example.theair.presentation.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TheAirApplication : Application() {

    // here using Koin we start our app and register module ands and repo and viewModels
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@TheAirApplication)
            modules(listOf(networkModule, repositoryModule, viewModelModule))
        }
    }
}