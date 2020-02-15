package com.example.friends.di.component

import com.example.apaga.main.di.module.ActivityModule
import com.example.apaga.main.login.LoginActivity
import com.example.friends.di.*
import dagger.Component

@ActivityScope
@Component(
        dependencies = [ApplicationComponent::class],
        modules = [ActivityModule::class]
)
interface ActivityComponent {
    fun inject(activity: LoginActivity)
}