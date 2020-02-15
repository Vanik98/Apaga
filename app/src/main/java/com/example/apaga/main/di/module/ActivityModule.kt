package com.example.apaga.main.di.module

import com.example.apaga.main.base.BaseActivity
import dagger.Module
import dagger.Provides

@Module
class ActivityModule (
        private val activity: BaseActivity
) {
    @Provides
    fun provideActivity() = activity

}