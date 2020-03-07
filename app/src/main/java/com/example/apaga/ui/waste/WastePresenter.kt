package com.example.apaga.ui.waste

import com.example.apaga.data.DataManager
import com.example.apaga.ui.base.BasePresenter
import com.example.apaga.ui.payment.PaymentContract
import javax.inject.Inject

class WastePresenter @Inject constructor(dataManager: DataManager
) : BasePresenter<WasteContract.View>(dataManager), WasteContract.Presenter{

}