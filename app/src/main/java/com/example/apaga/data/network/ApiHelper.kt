package com.example.apaga.data.network

import android.telecom.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiHelper {

    @GET("Search")
    fun getUser(@Query("api-key") apiKey: String): Call

}