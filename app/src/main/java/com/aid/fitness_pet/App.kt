package com.aid.fitness_pet

import android.app.Application
import com.backendless.Backendless
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Backendless.initApp(this, BuildConfig.API_ID, BuildConfig.API_KEY)
    }
}
