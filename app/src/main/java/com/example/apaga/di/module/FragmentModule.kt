package com.example.apaga.di.module

import com.example.apaga.ui.base.BaseFragment
import com.example.apaga.ui.payment.PaymentContract
import com.example.apaga.ui.payment.PaymentPresenter
import dagger.Module
import dagger.Provides
@Module
class FragmentModule (
        private val fragment:BaseFragment
){
    @Provides
    fun provideFragment() = fragment

    @Provides fun providePaymentPresenter(): PaymentContract.Presenter = PaymentPresenter()

}