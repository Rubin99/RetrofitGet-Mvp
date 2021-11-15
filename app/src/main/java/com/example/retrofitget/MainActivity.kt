package com.example.retrofitget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitget.api.RetrofitHelper
import com.example.retrofitget.model.VehicleList
import com.example.retrofitget.model.VehicleListData
import com.hannesdorfmann.mosby3.mvp.MvpActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class MainActivity : MvpActivity<VehicleView, VehiclePresenter>(), VehicleView {

    //private lateinit var tvVehicles: TextView
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: RecyclerAdapter
    var vehicles: MutableList<VehicleListData> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //tvVehicles = findViewById(R.id.tvVehicles)
        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.adapter= RecyclerAdapter(vehicles,this)
        recyclerView.layoutManager= LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        setUp()
    }

    private fun setUp() {
        getVehiclesInfo()
    }

    private fun getVehiclesInfo() {

        presenter.callVehicleApi()
        /*RetrofitHelper.getApiService().getVehicleData().enqueue(object : Callback<VehicleList?> {
            override fun onResponse(call: Call<VehicleList?>, response: Response<VehicleList?>) {
                val vehiclesResponseBody = response.body()
                vehicles.addAll(vehiclesResponseBody!!.data)
                recyclerView.adapter?.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<VehicleList?>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Not working", Toast.LENGTH_LONG).show()
            }
        })*/
    }

    override fun createPresenter() = VehiclePresenter()
    override fun displayVehicles() {
        recyclerView.adapter?.notifyDataSetChanged()
    }

    /*RetrofitHelper.getApiService().getVehicleData()
    .enqueue(object : Callback<VehicleList?> {
        override fun onResponse(
            call: Call<VehicleList?>,
            response: Response<VehicleList?>
        ) {
            val vehicleResponse = response.body()
            val stringBuilder = "chassis_number: " +
                    vehicleResponse?.data
            *//*"\n" +
            "chassis_number: " +
            vehicleResponse?.color +
            "\n" +
            "chassis_number: " +
            vehicleResponse?.model +
            "\n" +
            "chassis_number: " +
            vehicleResponse?.photo_count +
            "\n" +
            "chassis_number: " +
            vehicleResponse?.purchase_date +
            "\n" +
            "chassis_number: " +
            vehicleResponse?.purchase_destination +
            "\n" +
            "chassis_number: " +
            vehicleResponse?.reference_number +
            "\n" +
            "chassis_number: " +
            vehicleResponse?.sales_person +
            "\n" +
            "chassis_number: " +
            vehicleResponse?.vehicle_image +
            "\n"
*//*
            tvVehicles.text = stringBuilder
        }

        override fun onFailure(call: Call<VehicleList?>, t: Throwable) {
            tvVehicles.text = t.message
        }
    })*/
}