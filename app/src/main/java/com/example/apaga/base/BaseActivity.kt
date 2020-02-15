package com.example.apaga.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.apaga.main.ApagaApplication
import com.example.friends.di.component.ApplicationComponent


abstract class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupComponent(ApagaApplication.get(this).getAppComponent())
    }

    abstract fun setupComponent(applicationComponent: ApplicationComponent)

}