package com.example.apaga.di.component
import com.example.apaga.di.ActivityScope
import com.example.apaga.di.module.ActivityModule
import com.example.apaga.ui.login.LoginActivity
import dagger.Component

@ActivityScope
@Component(
        dependencies = [AppComponent::class],
        modules = [ActivityModule::class]
)
interface ActivityComponent {
    fun inject(activity: LoginActivity)
}