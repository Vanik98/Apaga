package com.example.apaga.di.builder

import com.example.apaga.MainActivity
import dagger.android.ContributesAndroidInjector


abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = {
        FeedActivityModule.class,
        BlogFragmentProvider.class,
        OpenSourceFragmentProvider.class
    })
    internal abstract fun bindFeedActivity(): FeedActivity

    @ContributesAndroidInjector
    internal abstract fun bindLoginActivity(): LoginActivity

    @ContributesAndroidInjector(modules = {
        AboutFragmentProvider.class,
        RateUsDialogProvider.class
    })
    internal abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    internal abstract fun bindSplashActivity(): SplashActivity
}