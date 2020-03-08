package com.example.apaga.ui.qrscanner

import com.example.apaga.data.DataManager
import com.example.apaga.ui.base.BasePresenter
import javax.inject.Inject

class QrScannerPresenter @Inject constructor(dataManager: DataManager
) : BasePresenter<QrScannerContract.View>(dataManager), QrScannerContract.Presenter{
}