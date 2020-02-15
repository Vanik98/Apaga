package com.example.apaga.data.network


import com.example.apaga.data.db.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppApiHelper : ApiHelper {
    override fun getUser(apiKey: String): Call<User> {
        val BASE_URL = "https://content.guardianapis.com/"
             Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiHelper::class.java).getUser("")
                .enqueue(object : Callback<User>{
                      override fun onFailure(call: retrofit2.Call<User>, t: Throwable) {
                          TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                      }

                      override fun onResponse(call: retrofit2.Call<User>, response: Response<User>) {
                          TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                      }

                  })

    }



}