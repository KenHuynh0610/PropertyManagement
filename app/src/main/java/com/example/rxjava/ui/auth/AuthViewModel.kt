package com.example.rxjava.ui.auth

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rxjava.data.LoginResponse
import com.example.rxjava.data.RetroManager
import com.example.rxjava.di.DaggerAppComponent
import com.example.rxjava.di.NetworkModule
import com.example.rxjava.session.SessionManager
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class AuthViewModel(val repo: RetroManager) : ViewModel() {

    val loginStatus = MutableLiveData<LoginAction>()

    var email: String? = null
    var password: String? = null

//    var sessionManager = SessionManager.getInstance()

    init {
//        DaggerAppComponent.builder().networkModule(NetworkModule()).build().inject()
    }

//    @Inject
//    lateinit var authRepo: AuthRepository

    enum class LoginAction(val message: String) {
        SUCCESS("Login Succeeded"),
        FAILURE("Login Failed"),
        MISSING_FIELD("Some Fields are missing")
    }

    fun onLoginButtonClicked(view: View) {
        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            loginStatus.value = LoginAction.MISSING_FIELD
        } else {
//            var response = authRepo.loginUser(User(email!!, password!!))
//            response.subscribeWith(LoginObserver())
        }
    }


    inner class LoginObserver() : SingleObserver<LoginResponse> {
        override fun onSubscribe(d: Disposable) {

        }

        override fun onSuccess(t: LoginResponse) {
            loginStatus.value = LoginAction.SUCCESS
//            sessionManager.register(t.user._id!!, t.user.name!!, t.user.email, t.user.password)
        }

        override fun onError(e: Throwable) {
            loginStatus.value = LoginAction.FAILURE
            Log.d("abc", e.message.toString())
        }

    }


}