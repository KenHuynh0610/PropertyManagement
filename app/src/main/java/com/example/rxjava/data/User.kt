package com.example.rxjava.data


data class RegisterUser(var name: String, var email: String, var password: String, var type: String)

data class LoginUser(var email: String, var password: String)

data class RegisterResponse(var error: String, var message: String, var data: ArrayList<UserData>)

data class UserData(
    var _id: String,
    var name: String,
    var email: String,
    var password: String,
    var type: String,
    var createdAt: String,
    var __v: Int
)

data class LoginResponse(var token: String, var user: UserData)