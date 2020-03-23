package com.example.apaga.ui.dashboard

import com.example.apaga.data.DataManager
import com.example.apaga.ui.base.BasePresenter
import javax.inject.Inject

class DashboardPresenter @Inject constructor(dataManager: DataManager
) : BasePresenter<DashboardContract.View>(dataManager), DashboardContract.Presenter{
}