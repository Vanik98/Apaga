package com.example.apaga.data.network

import android.telecom.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppApiHelper : ApiHelper {
    override fun getUser(apiKey: String): Call {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    val BASE_URL = "https://content.guardianapis.com/"

    private var retrofit: Retrofit? = null

    fun getApiClient(): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }
        return retrofit
    }
}