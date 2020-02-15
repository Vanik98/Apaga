package com.example.friends.di.module

import com.example.apaga.main.ApagaApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(
    private val application: ApagaApplication
) {
    @Provides @Singleton fun provideApplication() = application
}