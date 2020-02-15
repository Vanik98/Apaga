package com.example.apaga.main.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apaga.R
import com.example.apaga.main.base.BaseActivity
import com.example.apaga.main.di.module.ActivityModule
import com.example.friends.di.component.ApplicationComponent

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
