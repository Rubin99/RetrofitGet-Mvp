package com.example.retrofitget

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitget.model.VehicleList
import com.example.retrofitget.model.VehicleListData

class RecyclerAdapter (private var vehicle: List<VehicleListData>, private val context: Context): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.adapter_items_list, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        val vehicleListData = vehicle[position]

        //holder.tvVehicles.text = vehicleListData.chassis_number

        holder.tvRefNumber?.text = vehicleListData.reference_number
        holder.tvChassisNumber?.text = vehicleListData.chassis_number
        holder.tvPurchaseDate?.text = vehicleListData.purchase_date
        holder.tvModel?.text = vehicleListData.model
        holder.tvColor?.text = vehicleListData.color
        holder.tvSalesPerson?.text = vehicleListData.sales_person
        holder.tvPurchaseDestination?.text = vehicleListData.purchase_destination
        holder.ivVehicleImage?.text = vehicleListData.vehicle_image
        holder.tvPhotoCount?.text = vehicleListData.photo_count.toString()
    }

    override fun getItemCount(): Int {
        return  vehicle.size
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //lateinit var tvVehicles: TextView
        val tvRefNumber: TextView? = itemView?.findViewById(R.id.tvRefNumber)
        val tvChassisNumber: TextView? = itemView?.findViewById(R.id.tvChassisNumber)
        val tvPurchaseDate: TextView? = itemView?.findViewById(R.id.tvPurchaseDate)
        val tvModel: TextView? = itemView?.findViewById(R.id.tvModel)
        val tvColor: TextView? = itemView?.findViewById(R.id.tvColor)
        val tvSalesPerson: TextView? = itemView?.findViewById(R.id.tvSalesPerson)
        val tvPurchaseDestination: TextView? = itemView?.findViewById(R.id.tvPurchaseDestination)
        val ivVehicleImage: TextView? = itemView?.findViewById(R.id.ivVehicleImage)
        val tvPhotoCount: TextView? = itemView?.findViewById(R.id.tvPhotoCount)
        /*init {
            tvVehicles = itemView.findViewById(R.id.tvVehicles)

        }*/
    }
}