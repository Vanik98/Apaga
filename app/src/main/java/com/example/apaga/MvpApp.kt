package com.example.apaga


import android.app.Application
import android.content.Context
import com.example.apaga.di.component.AppComponent
import com.example.apaga.di.component.DaggerAppComponent
import com.example.friends.di.module.AppModule

class MvpApp : Application() {
    private lateinit var component: AppComponent

    companion object {
        fun get(context: Context): MvpApp {
            return context.applicationContext as MvpApp
        }
    }

    override fun onCreate() {
        super.onCreate()
        setupGraph()
    }

    private fun setupGraph() {
        component = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
        component.inject(this)
    }

    fun getAppComponent() = component

}