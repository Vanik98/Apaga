package com.example.apaga.ui.registration

import com.example.apaga.data.db.model.User
import com.example.apaga.ui.base.MvpPresenter
import com.example.apaga.ui.base.MvpView

interface RegistrationContract {
    interface View : MvpView {
    }

    interface Presenter : MvpPresenter<View> {
        fun registration(user: User){

        }
    }
}