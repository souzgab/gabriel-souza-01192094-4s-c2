package com.example.base.ApiConnection.Request

import com.example.base.ApiConnection.Data.CachorroDataClass
import com.example.base.ApiConnection.Response.CachorroResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface DataRequest {
    @Headers("Content-Type: application/json")
    @POST(value = "cachorros")
    fun post(@Body User: CachorroDataClass): Call<CachorroResponse>

    @Headers("Content-Type: application/json")
    @GET(value = "cachorros")
    fun get(): Call<List<CachorroResponse>>
}