package com.example.rxjava.di

import com.example.rxjava.data.Config
import com.example.rxjava.data.LoginUser
import com.example.rxjava.data.RegisterUser
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.POST

interface APIInterface {
    @POST(Config.REG_URL)
    fun postReg(user: RegisterUser): Single<RegisterUser>

    @POST(Config.LOGIN_URL)
    fun postLogin(user:LoginUser):Single<LoginUser>
}
