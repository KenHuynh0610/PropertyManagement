package com.example.rxjava.di

import android.app.Application
import com.example.rxjava.main.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(NetworkModule::class))

interface AppComponent {

    fun inject(activity: MainActivity)

    @Component.Builder
    interface Builder {
        fun build(): AppComponent?

        // @BindsInstance replaces Builder appModule(AppModule appModule)
        // And removes Constructor with Application AppModule(Application)
        @BindsInstance
        fun application(application: Application?): Builder?
    }
}