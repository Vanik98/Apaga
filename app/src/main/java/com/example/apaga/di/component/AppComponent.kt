package com.example.apaga.di.component

import com.example.apaga.MvvmApp
import dagger.Component
import javax.inject.Singleton
import android.app.Application
import com.example.apaga.di.builder.ActivityBuilder
import com.example.apaga.di.module.AppModule
import dagger.BindsInstance
import dagger.android.AndroidInjectionModule


class AppComponent {
    @Singleton
    @Component(modules = [AndroidInjectionModule::class, ActivityBuilder::class, AppModule::class])
    public interface AppComponent {

        fun inject(app: MvvmApp)

        @Component.Builder
        interface Builder {

            @BindsInstance
            fun application(application: Application): Builder

            fun build(): AppComponent
        }
    }
}