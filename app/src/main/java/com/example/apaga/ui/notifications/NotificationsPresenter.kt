package com.example.apaga.ui.notifications

import com.example.apaga.data.DataManager
import com.example.apaga.ui.base.BasePresenter
import javax.inject.Inject

class NotificationsPresenter  @Inject constructor(dataManager: DataManager
) : BasePresenter<NotificationsContract.View>(dataManager), NotificationsContract.Presenter{
}