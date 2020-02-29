package com.example.apaga.ui.home

import com.example.apaga.ui.base.MvpPresenter
import com.example.apaga.ui.base.MvpView

interface HomeContract {
    interface View : MvpView {
    }

    interface Presenter : MvpPresenter<View> {
        fun loadUser()
    }
}