package com.example.apaga.di.component

import com.example.apaga.di.PerActivity
import com.example.apaga.di.module.ActivityModule
import com.example.apaga.ui.address.AddressActivity
import com.example.apaga.ui.buybags.BuyBagasFragment
import com.example.apaga.ui.home.HomeActivity
import com.example.apaga.ui.login.LoginFragment
import com.example.apaga.ui.main.MainActivity
import com.example.apaga.ui.notifications.NotificationsFragment
import com.example.apaga.ui.payment.PaymentFragment
import com.example.apaga.ui.qrscanner.QrScannerFragment
import com.example.apaga.ui.registration.RegistrationFragment
import com.example.apaga.ui.settings.SettingsActivity
import com.example.apaga.ui.waste.WasteFragment
import dagger.Component


@PerActivity
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    //activities
    fun inject(activity: MainActivity)
    fun inject(activity: HomeActivity)
    fun inject(activity: AddressActivity)
    fun inject(activity: SettingsActivity)
    //fragments
    fun inject(fragment: LoginFragment)
    fun inject(fragment: BuyBagasFragment)
    fun inject(fragment: PaymentFragment)
    fun inject(fragment: RegistrationFragment)
    fun inject(fragment: NotificationsFragment)
    fun inject(fragment: WasteFragment)
    fun inject(fragment: QrScannerFragment)
}