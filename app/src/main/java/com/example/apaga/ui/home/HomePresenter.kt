package com.example.apaga.ui.home

import androidx.lifecycle.LiveData
import com.example.apaga.data.db.model.User

class HomePresenter(
        var model: HomeContract.Model
) : HomeContract.Presenter {
    override fun loadUser() {

    }

    lateinit var view:HomeContract.View
    override fun subscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun unsubscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun attach(view: HomeContract.View) {
        this.view = view
    }
}