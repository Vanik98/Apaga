package com.example.apaga.ui.buybags


import android.content.Context
import com.example.apaga.di.component.DaggerFragmentComponent
import com.example.apaga.di.module.FragmentModule
import com.example.apaga.ui.base.BaseFragment
import javax.inject.Inject

class BuyBagasFragment : BaseFragment(),BuyBagsContract.View {
    override fun setupComponent() {
        DaggerFragmentComponent.builder()
                .fragmentModule(FragmentModule(this))
                .build()
                .inject(this)
    }

    @Inject lateinit var presenter: BuyBagsContract.Presenter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        presenter.attach(this)
    }

}