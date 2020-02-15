package com.example.apaga


import android.app.Application
import android.content.Context
import com.example.apaga.di.component.ApplicationComponent
import com.example.apaga.di.component.DaggerApplicationComponent
import com.example.friends.di.module.ApplicationModule

class ApagaApplication : Application() {
    private lateinit var component: ApplicationComponent

    companion object {
        fun get(context: Context): ApagaApplication {
            return context.applicationContext as ApagaApplication
        }
    }

    override fun onCreate() {
        super.onCreate()
        setupGraph()
    }

    private fun setupGraph() {
        component = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
        component.inject(this)
    }

    fun getAppComponent() = component

}