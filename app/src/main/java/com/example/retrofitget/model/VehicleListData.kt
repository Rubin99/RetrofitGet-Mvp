package com.example.retrofitget.model

data class VehicleListData(
    val chassis_number: String,
    val color: String,
    val model: String,
    val photo_count: Int,
    val purchase_date: String,
    val purchase_destination: String,
    val reference_number: String,
    val sales_person: String,
    val vehicle_image: String
)