package com.example.apaga.ui.login

import com.example.apaga.data.DataManager
import com.example.apaga.ui.base.BasePresenter
import javax.inject.Inject

class LoginPresenter @Inject constructor(dataManager: DataManager
) : BasePresenter<LoginContract.View>(dataManager), LoginContract.Presenter{

    override fun onAttach(mvpView: LoginContract.View) {
        super.onAttach(mvpView)
    }

    override fun onDetach() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}