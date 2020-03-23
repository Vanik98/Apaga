package com.example.apaga.ui.dashboard

import com.example.apaga.ui.base.MvpPresenter
import com.example.apaga.ui.base.MvpView

interface DashboardContract {
    interface View : MvpView {

    }

    interface Presenter : MvpPresenter<View> {



    }
}