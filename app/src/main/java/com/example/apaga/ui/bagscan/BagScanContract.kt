package com.example.apaga.ui.bagscan

import com.example.apaga.ui.base.MvpPresenter
import com.example.apaga.ui.base.MvpView

interface BagScanContract {
    interface View : MvpView {
    }

    interface Presenter : MvpPresenter<View> {

    }
}