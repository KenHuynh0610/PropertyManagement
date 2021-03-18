package com.example.rxjava.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.rxjava.data.Config
import com.example.rxjava.data.RetroManager
import com.example.rxjava.main.MyApplication
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providesContext(myApplication: MyApplication): Context = myApplication.applicationContext

    @Singleton
    @Provides
    fun gsonFactoryProvider(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    fun rxJavaFactoryProvider(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.create()
    }

    @Provides
    @Singleton
    fun providePreferences(application: Application): SharedPreferences {
        return application.getSharedPreferences(
            "data",
            Context.MODE_PRIVATE
        );
    }


    @Singleton
    @Provides
    fun getApi(retrofit: Retrofit): APIInterface {
        return retrofit.create(APIInterface::class.java)
    }


    @Singleton
    @Provides
    fun retrofitProvider(gson: GsonConverterFactory, rxJava: RxJava2CallAdapterFactory): Retrofit {
        return Retrofit.Builder().baseUrl(Config.BASE_URL)
            .addCallAdapterFactory(rxJava)
            .addConverterFactory(gson).build()
    }
}