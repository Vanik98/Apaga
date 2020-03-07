package com.example.apaga.ui.waste

import com.example.apaga.ui.base.MvpPresenter
import com.example.apaga.ui.base.MvpView

interface WasteContract {
    interface View : MvpView {
    }

    interface Presenter : MvpPresenter<View> {

    }
}