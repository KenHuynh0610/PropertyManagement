package com.example.rxjava.main

import android.app.Application
import com.example.rxjava.di.AppComponent
import com.example.rxjava.di.DaggerAppComponent
import com.example.rxjava.di.NetworkModule

class MyApplication: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate(){
        super.onCreate()
       appComponent = DaggerAppComponent.builder().application(Application())?.build()!!
    }
}
