package com.example.apaga.ui.main

import android.os.Bundle
import com.bumptech.glide.request.RequestOptions
import com.example.apaga.data.DataManager
import com.example.apaga.ui.base.BasePresenter
import com.facebook.AccessToken
import com.facebook.AccessTokenTracker
import com.facebook.GraphRequest
import javax.inject.Inject

class MainPresenter @Inject constructor(dataManager: DataManager
) : BasePresenter<MainContract.View>(dataManager),MainContract.Presenter{

    override fun onAttach(mvpView: MainContract.View) {

    }

    override fun onDetach() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setUserAsLoggedOut() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }






}