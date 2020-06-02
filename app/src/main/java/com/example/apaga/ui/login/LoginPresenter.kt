package com.example.apaga.ui.login

import android.os.Bundle
import com.bumptech.glide.request.RequestOptions
import com.example.apaga.data.DataManager
import com.example.apaga.ui.base.BasePresenter
import com.example.apaga.ui.main.MainContract
import com.facebook.AccessToken
import com.facebook.AccessTokenTracker
import com.facebook.GraphRequest
import javax.inject.Inject

class LoginPresenter @Inject constructor(dataManager: DataManager
) : BasePresenter<LoginContract.View>(dataManager), LoginContract.Presenter{

    lateinit var view : LoginContract.View

    override fun onAttach(mvpView: LoginContract.View) {
        super.onAttach(mvpView)
        view = mvpView
    }

    override fun onDetach() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun accessTokenTracker() {
         object : AccessTokenTracker(){
            override fun onCurrentAccessTokenChanged(oldAccessToken: AccessToken?, currentAccessToken: AccessToken?) {
                if(currentAccessToken != null){
                    loginWithFacebook(currentAccessToken)
                }
            }
        }
    }

    override fun loginWithEmail(email: String, password: String) {
//        dataManager.loginWithEmail(email,password)
        view.openAddressActivity()
    }

    private fun loginWithFacebook(token: AccessToken) {
        val request = GraphRequest.newMeRequest(token) { o, response ->
            val first_name = o!!.getString("first_name")
            val requestOptions = RequestOptions()
            requestOptions.dontAnimate()
        }
        val b = Bundle()
        b.putString("fields","first_name,last_name,logo_email,id")
        request.parameters = b
        request.executeAsync()
        view.openHomeActivity()
    }
}