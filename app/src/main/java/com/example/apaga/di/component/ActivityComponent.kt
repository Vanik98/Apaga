package com.example.apaga.di.component

import com.example.apaga.di.PerActivity
import com.example.apaga.di.module.ActivityModule
import com.example.apaga.ui.buybags.BuyBagasFragment
import com.example.apaga.ui.home.HomeActivity
import com.example.apaga.ui.login.LoginFragment
import com.example.apaga.ui.main.MainActivity
import com.example.apaga.ui.payment.PaymentFragment
import dagger.Component


@PerActivity
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    //activities
    fun inject(activity: MainActivity)
    fun inject(activity: HomeActivity)
    fun inject(activity: PaymentFragment)
    //fragments
    fun inject(fragment: LoginFragment)
    fun inject(fragment: BuyBagasFragment)

}