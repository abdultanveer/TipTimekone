package com.example.tiptime

import android.app.Application
import com.example.tiptime.data.AppDatabase

class MyApp : Application() {

    // Lazy initialization (created only when first used)
    val database: AppDatabase by lazy {
        AppDatabase.getDatabase(this)
    }
}