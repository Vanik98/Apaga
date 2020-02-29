package com.example.apaga.ui.payment

import com.example.apaga.data.DataManager
import com.example.apaga.ui.base.BasePresenter
import javax.inject.Inject

class PaymentPresenter @Inject constructor(dataManager: DataManager
) : BasePresenter<PaymentContract.View>(dataManager),PaymentContract.Presenter{

    override fun onAttach(mvpView: PaymentContract.View) {
        super.onAttach(mvpView)
    }

    override fun onDetach() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}