package com.example.apaga.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.apaga.MvpApp
import com.example.apaga.di.component.AppComponent



abstract class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupComponent(MvpApp.get(this).getAppComponent())
    }

    abstract fun setupComponent(appComponent: AppComponent)

}