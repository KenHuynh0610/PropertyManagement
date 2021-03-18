package com.example.rxjava.session

import android.content.Context
import android.content.SharedPreferences
import com.example.rxjava.main.MyApplication
import javax.inject.Inject

class SessionManager @Inject constructor(var context: Context){
    private val FILE_NAME = "data"
    private val USER_NAME = "Name"
    private val USER_EMAIL = "email"
    private val USER_ID = "id"
    private val USER_PASSWORD = "password"
    private val USER_TYPE = "type"

//    private val sharedPreferences: SharedPreferences = context.getSharedPreferences()
}
