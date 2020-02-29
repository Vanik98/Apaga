package com.example.apaga.ui.buybags

import com.example.apaga.data.DataManager
import com.example.apaga.ui.base.BasePresenter
import javax.inject.Inject

class BuyBagsPresenter @Inject constructor(dataManager: DataManager
) : BasePresenter<BuyBagsContract.View>(dataManager),BuyBagsContract.Presenter{
    
    override fun onAttach(mvpView: BuyBagsContract.View) {
        super.onAttach(mvpView)
    }

    override fun onDetach() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}