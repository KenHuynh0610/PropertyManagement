package com.example.rxjava.data

class Config {
    companion object{
        const val BASE_URL = "https://apolis-property-management.herokuapp.com/api/"
        const val LOGIN_URL = "auth/login"
        const val REG_URL = "auth/register"
    }

    fun postLogin(): String{
        return BASE_URL + LOGIN_URL
    }

    fun postRegister(): String{
        return BASE_URL + REG_URL
    }
}