package com.example.parcialtp3.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CarsServiceApiBuilder {

    private val BASE_URL = "https://api.api-ninjas.com/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun create(): CarsService {
        return retrofit.create(CarsService::class.java)
    }
}