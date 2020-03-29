package com.example.apaga.ui.schedule

import com.example.apaga.ui.base.MvpPresenter
import com.example.apaga.ui.base.MvpView

interface SchedulePickupContract {
    interface View : MvpView {
    }

    interface Presenter : MvpPresenter<View> {

    }
}