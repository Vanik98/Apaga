package com.example.apaga.ui.home

import androidx.lifecycle.LiveData
import com.example.apaga.data.db.model.User
import com.example.apaga.ui.base.MvpModel
import com.example.apaga.ui.base.MvpPresenter
import com.example.apaga.ui.base.MvpView

interface HomeContract {
    interface View : MvpView {
    }

    interface Presenter : MvpPresenter<View> {
        fun loadUser()
    }

    interface Model : MvpModel {


    }

}