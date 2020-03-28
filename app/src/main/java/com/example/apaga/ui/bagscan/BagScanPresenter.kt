package com.example.apaga.ui.bagscan

import com.example.apaga.data.DataManager
import com.example.apaga.ui.base.BasePresenter
import javax.inject.Inject

class BagScanPresenter @Inject constructor(dataManager: DataManager
) : BasePresenter<BagScanContract.View>(dataManager), BagScanContract.Presenter{
}