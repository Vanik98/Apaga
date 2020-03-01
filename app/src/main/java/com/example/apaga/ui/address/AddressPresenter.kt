package com.example.apaga.ui.address

import com.example.apaga.data.DataManager
import com.example.apaga.ui.base.BasePresenter
import javax.inject.Inject

class AddressPresenter @Inject constructor(dataManager: DataManager
) : BasePresenter<AddressContract.View>(dataManager), AddressContract.Presenter{
    override fun onAttach(mvpView: AddressContract.View) {
        super.onAttach(mvpView)
    }
}