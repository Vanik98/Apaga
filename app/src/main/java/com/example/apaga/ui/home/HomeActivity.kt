package com.example.apaga.ui.home

import android.os.Bundle
import com.example.apaga.R
import com.example.apaga.di.component.AppComponent
import com.example.apaga.di.component.DaggerActivityComponent
import com.example.apaga.di.module.ActivityModule
import com.example.apaga.ui.base.BaseActivity
import javax.inject.Inject

class HomeActivity : BaseActivity(),HomeContract.View {

    override fun setupComponent(appComponent: AppComponent) {
        DaggerActivityComponent.builder()
                .appComponent(appComponent)
                .activityModule(ActivityModule(this))
                .build()
                .inject(this)
    }

    @Inject lateinit var presenter: HomeContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

}
