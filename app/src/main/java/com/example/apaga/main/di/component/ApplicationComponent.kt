package com.example.friends.di.component

import com.example.apaga.main.ApagaApplication
import com.example.friends.di.module.ApplicationModule
import com.example.friends.di.module.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, NetworkModule::class])
interface ApplicationComponent {
     fun inject(app: ApagaApplication)
}