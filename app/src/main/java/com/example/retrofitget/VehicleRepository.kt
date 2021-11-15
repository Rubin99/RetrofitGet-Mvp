package com.example.retrofitget

import com.example.retrofitget.api.RetrofitHelper
import com.example.retrofitget.model.VehicleList
import com.example.retrofitget.model.VehicleListData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

object VehicleRepository  {
    var vehicles: MutableList<VehicleListData> = ArrayList()

    fun callVehicle(apiResponse: ApiResponse<VehicleList>) {
        RetrofitHelper.getApiService().getVehicleData().enqueue(object : Callback<VehicleList?> {
            override fun onResponse(call: Call<VehicleList?>, response: Response<VehicleList?>) {
                apiResponse.onSuccess(response.body()!!)
            }

            override fun onFailure(call: Call<VehicleList?>, t: Throwable) {
                apiResponse.onFaliure(t.message)
            }
        })
    }
    /*fun callVehicle() = RetrofitHelper.getApiService().getVehicleData().enqueue(object : Callback<VehicleList?> {
        private val gsonConverter = GsonConverterFactory.create(GsonBuilder().setLenient().create())

        override fun onResponse(call: Call<VehicleList?>, response: Response<VehicleList?>) {
            val vehiclesResponseBody = response.body()
            vehicles.addAll(vehiclesResponseBody!!.data)
        }

        override fun onFailure(call: Call<VehicleList?>, t: Throwable) {
        }
    })*/
}