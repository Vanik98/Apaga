package com.example.apaga.ui.login

import android.os.Bundle
import com.example.apaga.R
import com.example.apaga.ui.base.BaseActivity
import com.example.apaga.di.component.ApplicationComponent
import com.example.apaga.di.component.DaggerActivityComponent
import com.example.apaga.di.module.ActivityModule
import javax.inject.Inject

class LoginActivity : BaseActivity(), LoginContract.View {

    override fun setupComponent(applicationComponent: ApplicationComponent) {
        DaggerActivityComponent.builder()
                .applicationComponent(applicationComponent)
                .activityModule(ActivityModule(this))
                .build()
                .inject(this)
    }

    @Inject
    lateinit var presenter: LoginContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        presenter.attach(this)
    }

    override fun onStart() {
        presenter.subscribe()
        super.onStart()
    }

    override fun onPause() {
        presenter.unsubscribe()
        super.onPause()
    }

}
