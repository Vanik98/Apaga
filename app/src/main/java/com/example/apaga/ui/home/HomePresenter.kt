package com.example.apaga.ui.home

import androidx.lifecycle.LiveData
import com.example.apaga.data.DataManager
import com.example.apaga.data.db.model.User
import com.example.apaga.ui.base.BasePresenter
import javax.inject.Inject

class HomePresenter @Inject constructor(dataManager: DataManager
) : BasePresenter<HomeContract.View>(dataManager),HomeContract.Presenter{
    override fun loadUser() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    lateinit var view:HomeContract.View

    override fun onAttach(mvpView: HomeContract.View) {
        super.onAttach(mvpView)
        this.view = view
    }
}