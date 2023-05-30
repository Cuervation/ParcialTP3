package com.example.parcialtp3.services

import com.example.parcialtp3.entities.Car
import com.example.parcialtp3.model.CarsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface CarsService {

    @Headers(
        "X-Api-Key: xF03pe/6MAf/V1FNOsmRkg==qwfG1ldFnXmJ2XBU"
    )
    @GET("/v1/cars")
    fun getCars(@Query("make") make: String,
                @Query("limit") limit: Int = 50,
    ): Call<MutableList<Car>?>
}