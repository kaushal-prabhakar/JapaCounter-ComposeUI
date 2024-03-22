package com.kaushal.composeui.base

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen

class ApplicationClass: Application() {

    override fun onCreate() {
        super.onCreate()

        AndroidThreeTen.init(this)
    }
}