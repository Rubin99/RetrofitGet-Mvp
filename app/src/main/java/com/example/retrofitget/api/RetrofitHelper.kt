package com.example.retrofitget.api

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitHelper {

    private var apiService: ApiService? = null
    private val gsonConverter = GsonConverterFactory.create(GsonBuilder().setLenient().create())

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(gsonConverter)
        .baseUrl("https://demo5212443.mockable.io")
        .client(getOkHttpClient())
        .build()

    private fun getOkHttpClient(): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES)
        return okHttpClient.build()
    }

    fun getApiService(): ApiService {
        if (apiService == null){
            apiService = retrofit.create(ApiService::class.java)
        }
        return apiService ?: retrofit.create(ApiService::class.java)
    }
}