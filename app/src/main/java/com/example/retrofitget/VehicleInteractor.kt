package com.example.retrofitget

import com.example.retrofitget.model.VehicleList

class VehicleInteractor {
fun callVehicle(apiResponse: ApiResponse<VehicleList>) = VehicleRepository.callVehicle(apiResponse)
}
