package com.example.parcialtp3.entities

import com.google.gson.annotations.SerializedName

data class Car (
    @SerializedName(value = "car") val name: String? = "",
    val city_mpg: Int? = 0,
    val `class`: String? = "",
    val combination_mpg: Int? = 0,
    val cylinders: Int? = 0,
    val displacement: Float? = Float.MIN_VALUE,
    val drive: String? = "",
    val fuel_type: String? = "",
    val highway_mpg: Int? = 0,
    val make: String? = "",
    val model: String? = "",
    val transmission: String? = "",
    val year: Int? = 0,
)