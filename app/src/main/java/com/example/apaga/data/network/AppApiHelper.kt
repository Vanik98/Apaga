package com.example.apaga.data.network


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.apaga.data.db.model.User
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppApiHelper : ApiHelper {
    override fun getUser(): LiveData<User> {
        val liveData = MutableLiveData<User>()
             Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiHeader::class.java).getUser("")
                .enqueue(object : Callback<User>{
                      override fun onFailure(call: retrofit2.Call<User>, t: Throwable) {
                         }
                      override fun onResponse(call: retrofit2.Call<User>, response: Response<User>) {
                          liveData.value = response.body()
                      }
                  })
        return liveData
    }

    override fun loginWithEmail(email: String, password: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}