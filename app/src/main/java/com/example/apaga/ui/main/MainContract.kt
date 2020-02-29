package com.example.apaga.ui.main
import com.example.apaga.ui.base.MvpPresenter
import com.example.apaga.ui.base.MvpView


interface MainContract{

    interface View : MvpView{

    }

    interface Presenter : MvpPresenter<View> {



    }
}