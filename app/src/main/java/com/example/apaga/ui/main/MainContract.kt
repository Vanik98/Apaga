package com.example.apaga.ui.main
import com.example.apaga.ui.base.MvpPresenter
import com.example.apaga.ui.base.MvpView


interface MainContract{

    interface View : MvpView{
        fun openRegistrationEmailFragment()

        fun openRegistrationFacebookActivity()

        fun openHomeActivity()
    }

    interface Presenter : MvpPresenter<View> {

        fun loginWithEmail(email:String,password:String)

        fun accessTokenTracker()

    }
}