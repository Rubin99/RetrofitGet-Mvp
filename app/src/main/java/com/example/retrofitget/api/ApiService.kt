package com.example.retrofitget.api

import com.example.retrofitget.model.VehicleList
import com.example.retrofitget.model.VehicleListData
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/vehicleList")
    fun getVehicleData() : Call<VehicleList>
}