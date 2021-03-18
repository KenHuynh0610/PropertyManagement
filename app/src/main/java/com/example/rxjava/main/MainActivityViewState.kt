package com.example.rxjava.main

import com.example.rxjava.data.User

sealed class MainActivityViewState {
    object ShowLoading:MainActivityViewState()
    class ShowError (val error: Throwable) : MainActivityViewState()
    class ShowData (val data: List<User>) : MainActivityViewState()
}