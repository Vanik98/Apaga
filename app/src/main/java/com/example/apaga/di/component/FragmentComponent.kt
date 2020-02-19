package com.example.apaga.di.component

import com.example.apaga.di.FragmentScope
import com.example.apaga.di.module.ActivityModule
import com.example.apaga.di.module.FragmentModule
import com.example.apaga.ui.payment.PaymentFragment
import dagger.Component

@FragmentScope
@Component(
        modules = [FragmentModule :: class]
)
interface FragmentComponent {
    fun inject(activity: PaymentFragment)
}