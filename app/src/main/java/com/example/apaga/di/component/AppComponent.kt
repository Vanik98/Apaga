package com.example.apaga.di.component

import com.example.apaga.MvpApp
import com.example.friends.di.module.AppModule
import com.example.friends.di.module.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class])
interface AppComponent {
     fun inject(app: MvpApp)
}