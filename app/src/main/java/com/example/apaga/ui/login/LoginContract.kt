package com.example.apaga.ui.login

import com.example.apaga.ui.base.MvpModel
import com.example.apaga.ui.base.MvpPresenter
import com.example.apaga.ui.base.MvpView

interface LoginContract{

    interface View : MvpView{
        fun openRegistrationEmailFragment()

        fun openRegistrationFacebookActivity()

        fun openHomeActivity()
    }

    interface Presenter : MvpPresenter<View> {
        fun login(email:String,password:String)
    }

    interface Model : MvpModel {
    }

}