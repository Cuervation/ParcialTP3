package com.example.parcialtp3.services

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object CarsServiceApiBuilder {

    private val BASE_URL = "https://api.api-ninjas.com/"

    fun createRetrofit():  Retrofit {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        return retrofit
    }
    private val retrofit = createRetrofit()

    fun create(): CarsService {
        return retrofit.create(CarsService::class.java)
    }
}