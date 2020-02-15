package com.example.apaga.ui.login

import com.example.apaga.ui.base.MvpModel
import com.example.apaga.ui.base.MvpPresenter
import com.example.apaga.ui.base.MvpView

interface LoginContract{

    interface View : MvpView{
    }

    interface Presenter : MvpPresenter<View> {

    }

    interface Model : MvpModel {
    }

}