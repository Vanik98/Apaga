package com.example.apaga.ui.registration

import com.example.apaga.data.DataManager
import com.example.apaga.ui.base.BasePresenter
import com.example.apaga.ui.login.LoginContract
import javax.inject.Inject

class RegistrationPresenter @Inject constructor(dataManager: DataManager
) : BasePresenter<RegistrationContract.View>(dataManager), RegistrationContract.Presenter{
}