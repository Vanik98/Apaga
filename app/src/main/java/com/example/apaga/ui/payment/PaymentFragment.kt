package com.example.apaga.ui.payment


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.apaga.R
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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_payment,container,false)
    }
}