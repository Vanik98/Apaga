package com.example.apaga.di.module

import dagger.Module
import javax.inject.Singleton
import dagger.Provides
import android.app.Application
import android.content.Context


@Module
class AppModule {
    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }
}