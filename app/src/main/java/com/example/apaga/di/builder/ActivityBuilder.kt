package com.example.apaga.di.builder

import com.example.apaga.main.MainActivity
import dagger.android.ContributesAndroidInjector


abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = {
        FeedActivityModule.class,
    })


    @ContributesAndroidInjector()
    internal abstract fun bindMainActivity(): MainActivity


}