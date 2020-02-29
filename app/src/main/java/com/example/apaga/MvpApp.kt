package com.example.apaga


import android.app.Application
import com.example.apaga.data.DataManager
import com.example.apaga.di.component.ApplicationComponent
import com.example.apaga.di.component.DaggerApplicationComponent
import com.example.apaga.di.module.ApplicationModule
import javax.inject.Inject

class MvpApp : Application() {
    @Inject
    lateinit var mDataManager: DataManager

//    @Inject
//    var mCalligraphyConfig: CalligraphyConfig? = null

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this)).build()
        applicationComponent.inject(this)
//        AppLogger.init()
//        AndroidNetworking.initialize(applicationContext)
//        if (BuildConfig.DEBUG) {
//            AndroidNetworking.enableLogging(Level.BODY)
//        }
//        CalligraphyConfig.initDefault(mCalligraphyConfig)
//    }



    }
}