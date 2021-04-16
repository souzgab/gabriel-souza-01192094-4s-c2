package com.example.base.ApiConnection

import com.example.base.ApiConnection.Request.DataRequest
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Conection {
    private const val apiPath: String = "https://5f861cfdc8a16a0016e6aacd.mockapi.io/bandtec-api/"
    fun criar(): DataRequest {
            return Retrofit.Builder()
            .baseUrl(apiPath)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DataRequest::class.java)
    }
}