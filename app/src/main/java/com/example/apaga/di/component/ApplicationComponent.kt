package com.example.apaga.di.component

import com.example.apaga.ApagaApplication
import com.example.friends.di.module.ApplicationModule
import com.example.friends.di.module.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, NetworkModule::class])
interface ApplicationComponent {
     fun inject(app: ApagaApplication)
}