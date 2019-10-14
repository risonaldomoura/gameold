package com.riso.kotlintest.base

import android.app.Application

open class CustomApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: CustomApplication
            private set
    }

}