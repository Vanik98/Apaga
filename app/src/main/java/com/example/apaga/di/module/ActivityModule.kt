package com.example.apaga.di.module

import com.example.apaga.base.BaseActivity
import dagger.Module
import dagger.Provides

@Module
class ActivityModule (
        private val activity: BaseActivity
) {
    @Provides
    fun provideActivity() = activity

}