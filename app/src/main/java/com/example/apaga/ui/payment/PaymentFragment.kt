package com.example.apaga.ui.payment


import android.content.Context
import com.example.apaga.di.component.DaggerFragmentComponent
import com.example.apaga.di.module.FragmentModule
import com.example.apaga.ui.base.BaseFragment
import javax.inject.Inject

class PaymentFragment : BaseFragment(),PaymentContract.View {
    override fun setupComponent() {
        DaggerFragmentComponent.builder()
                .fragmentModule(FragmentModule(this))
                .build()
                .inject(this)
    }

    @Inject lateinit var presenter:PaymentContract.Presenter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        presenter.attach(this)

    }
}