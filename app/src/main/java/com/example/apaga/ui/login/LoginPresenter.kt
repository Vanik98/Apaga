package com.example.apaga.ui.login

import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.request.RequestOptions
import com.example.apaga.data.db.model.User
import com.facebook.AccessToken
import com.facebook.AccessTokenTracker
import com.facebook.GraphRequest
import com.facebook.GraphResponse
import org.json.JSONObject
import javax.inject.Inject

class LoginPresenter @Inject constructor(

) : LoginContract.Presenter{

    override fun accessTokenTracker() {
        val accessTokenTracker = object : AccessTokenTracker(){
            override fun onCurrentAccessTokenChanged(oldAccessToken: AccessToken?, currentAccessToken: AccessToken?) {
                if(currentAccessToken != null){
                    loginWithFacebook(currentAccessToken)
                }
            }
        }
    }

    lateinit var view : LoginContract.View

    override fun loginWithEmail(email: String, password: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun loginWithFacebook(token: AccessToken) {
        val request = GraphRequest.newMeRequest(token) { o, response ->
            val first_name = o!!.getString("first_name")
            val requestOptions = RequestOptions()
            requestOptions.dontAnimate()
        }
        val b = Bundle()
        b.putString("fields","first_name,last_name,email,id")
        request.parameters = b
        request.executeAsync()
        view.openHomeActivity()
    }

    override fun subscribe() {

    }

    override fun unsubscribe() {

    }

    override fun attach(view: LoginContract.View) {
        this.view = view
    }

}