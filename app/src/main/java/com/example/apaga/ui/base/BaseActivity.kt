package com.example.apaga.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.apaga.ApagaApplication
import com.example.apaga.di.component.ApplicationComponent



abstract class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupComponent(ApagaApplication.get(this).getAppComponent())
    }

    abstract fun setupComponent(applicationComponent: ApplicationComponent)

}