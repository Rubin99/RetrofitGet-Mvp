package com.example.retrofitget

interface ApiResponse<T> {
    fun onSuccess(response: T)
    fun onFaliure(message:String?)
}