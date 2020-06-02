package com.example.apaga.data.network

import com.example.apaga.data.db.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiHeader {
    @GET("")
    fun getUser(@Query("api-key") apiKey: String): Call<User>
}