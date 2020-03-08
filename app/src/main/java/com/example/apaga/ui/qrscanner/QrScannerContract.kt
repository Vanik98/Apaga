package com.example.apaga.ui.qrscanner

import com.example.apaga.ui.base.MvpPresenter
import com.example.apaga.ui.base.MvpView

interface QrScannerContract {
    interface View : MvpView {
    }

    interface Presenter : MvpPresenter<View> {

    }
}