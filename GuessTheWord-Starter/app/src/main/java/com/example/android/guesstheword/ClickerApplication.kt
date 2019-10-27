package com.example.android.guesstheword

import android.app.Application
import timber.log.Timber

/**
 * Created by charles on 23,October,2019
 */
class ClickerApplication:Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}