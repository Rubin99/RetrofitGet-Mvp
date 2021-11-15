package com.example.retrofitget

import com.example.retrofitget.model.VehicleList
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter

class VehiclePresenter: MvpBasePresenter<VehicleView>() {

    private var vehicleInteractor: VehicleInteractor? = null

    override fun attachView(view: VehicleView) {
        super.attachView(view)
        vehicleInteractor = VehicleInteractor()
    }

    override fun detachView() {
        super.detachView()
        vehicleInteractor = null
    }

    fun callVehicleApi(){
        ifViewAttached { view ->
            vehicleInteractor?.callVehicle(object : ApiResponse<VehicleList>{
                override fun onSuccess(response: VehicleList) {
                    view.displayVehicles()
                }

                override fun onFaliure(message: String?) {

                }
            })
        }
    }

}
