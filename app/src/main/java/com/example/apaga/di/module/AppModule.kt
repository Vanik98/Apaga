package com.example.friends.di.module

import com.example.apaga.MvpApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(
    private val application: MvpApp
) {
    @Provides @Singleton fun provideApplication() = application
}