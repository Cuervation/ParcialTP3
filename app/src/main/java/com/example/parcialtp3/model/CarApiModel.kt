package com.example.parcialtp3.model

import com.google.gson.annotations.SerializedName

data class CarApiModel (
    @SerializedName(value = "car") val name: String?,
    val city_mpg: Int?,
    val `class`: String?,
    val combination_mpg: Int?,
    val cylinders: Int?,
    val displacement: Int?,
    val drive: String?,
    val fuel_type: String?,
    val highway_mpg: Int?,
    val make: String?,
    val model: String?,
    val transmission: String?,
    val year: Int?,
    )
