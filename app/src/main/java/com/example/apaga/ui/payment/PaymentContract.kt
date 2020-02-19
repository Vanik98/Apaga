package com.example.apaga.ui.payment

import com.example.apaga.ui.base.MvpModel
import com.example.apaga.ui.base.MvpPresenter
import com.example.apaga.ui.base.MvpView

interface PaymentContract {
    interface View : MvpView {
    }

    interface Presenter : MvpPresenter<View> {

    }

    interface Model : MvpModel {
    }
}