package com.example.apaga.di.module

import com.example.apaga.ui.base.BaseActivity
import com.example.apaga.ui.login.LoginContract
import com.example.apaga.ui.login.LoginModel
import com.example.apaga.ui.login.LoginPresenter
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(
        private val activity: BaseActivity
) {
    @Provides fun provideActivity() = activity

    @Provides fun provideLoginPresenter(model: LoginContract.Model): LoginContract.Presenter = LoginPresenter(model)

    @Provides fun provideLoginModel(): LoginContract.Model = LoginModel()
}