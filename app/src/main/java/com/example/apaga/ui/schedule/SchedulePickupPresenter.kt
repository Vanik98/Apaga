package com.example.apaga.ui.schedule

import com.example.apaga.data.DataManager
import com.example.apaga.ui.base.BasePresenter
import javax.inject.Inject

class SchedulePickupPresenter @Inject constructor(dataManager: DataManager
) : BasePresenter<SchedulePickupContract.View>(dataManager), SchedulePickupContract.Presenter{

}