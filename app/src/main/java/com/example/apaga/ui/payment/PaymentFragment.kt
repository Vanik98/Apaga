package com.example.apaga.ui.payment


import android.content.Context
import androidx.fragment.app.Fragment
import com.example.apaga.di.component.DaggerFragmentComponent
import com.example.apaga.di.component.FragmentComponent
import com.example.apaga.di.module.ActivityModule
import com.example.apaga.di.module.FragmentModule
import com.example.apaga.ui.base.BaseFragment
import javax.inject.Inject


class PaymentFragment : BaseFragment(),PaymentContract.View {

    @Inject lateinit var presenter:PaymentContract.Presenter

    override fun onAttach(context: Context) {
        super.onAttach(context)

            DaggerFragmentComponent.builder()
                    .fragmentModule(FragmentModule(this))
                    .build()
                    .inject(this)
        presenter.attach(this)

    }
}