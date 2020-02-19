package com.example.apaga.di.module

import com.example.apaga.ui.base.BaseActivity
import com.example.apaga.ui.home.HomeContract
import com.example.apaga.ui.home.HomeModel
import com.example.apaga.ui.home.HomePresenter
import com.example.apaga.ui.login.LoginContract
import com.example.apaga.ui.login.LoginModel
import com.example.apaga.ui.login.LoginPresenter
import com.example.apaga.utils.DialogUtils
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(
        private val activity: BaseActivity
) {
    @Provides fun provideActivity() = activity

    @Provides fun provideLoginPresenter(model: LoginContract.Model): LoginContract.Presenter = LoginPresenter(model)

    @Provides fun provideLoginModel(): LoginContract.Model = LoginModel()

    @Provides fun provideHomePresenter(model: HomeContract.Model): HomeContract.Presenter = HomePresenter(model)

    @Provides fun provideHomeModel(): HomeContract.Model = HomeModel()

    @Provides fun provideDialogUtil(): DialogUtils = DialogUtils()
}