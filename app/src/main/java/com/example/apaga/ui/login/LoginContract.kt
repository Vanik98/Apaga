package com.example.apaga.ui.login

import com.example.apaga.data.db.model.User
import com.example.apaga.ui.base.MvpModel
import com.example.apaga.ui.base.MvpPresenter
import com.example.apaga.ui.base.MvpView
import com.facebook.AccessToken

interface LoginContract{

    interface View : MvpView{
        fun openRegistrationEmailFragment()

        fun openRegistrationFacebookActivity()

        fun openHomeActivity()
    }

    interface Presenter : MvpPresenter<View> {

        fun loginWithEmail(email:String,password:String)

        fun accessTokenTracker()

    }

    interface Model : MvpModel {
    }

}