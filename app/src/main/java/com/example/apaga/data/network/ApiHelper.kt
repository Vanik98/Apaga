package com.example.apaga.data.network

import androidx.lifecycle.LiveData
import com.example.apaga.data.db.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiHelper {
    val BASE_URL: String
        get() = "https://content.guardianapis.com/"

    fun getUser() : LiveData<User>
}