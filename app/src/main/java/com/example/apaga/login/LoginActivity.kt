package com.example.apaga.login

import android.os.Bundle
import com.example.apaga.R
import com.example.apaga.base.BaseActivity
import com.example.apaga.di.component.ApplicationComponent
import com.example.apaga.di.component.DaggerActivityComponent
import com.example.apaga.di.module.ActivityModule
class LoginActivity : BaseActivity() {

    override fun setupComponent(applicationComponent: ApplicationComponent) {
        DaggerActivityComponent.builder()
                .applicationComponent(applicationComponent)
                .activityModule(ActivityModule(this))
                .build()
                .inject(this)
       }

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }


}
