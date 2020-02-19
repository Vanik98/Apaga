package com.example.apaga.ui.login

import javax.inject.Inject

class LoginPresenter @Inject constructor(
        var model: LoginContract.Model
) : LoginContract.Presenter{
    lateinit var view : LoginContract.View
    override fun login(email: String, password: String) {
        if(true){
            view.openHomeActivity()
        }
    }

    override fun subscribe() {

    }

    override fun unsubscribe() {

    }

    override fun attach(view: LoginContract.View) {
        this.view = view
    }

}