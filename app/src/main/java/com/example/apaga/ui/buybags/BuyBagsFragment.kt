package com.example.apaga.ui.buybags


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.apaga.R
import com.example.apaga.di.component.ActivityComponent
import com.example.apaga.ui.base.BaseFragment
import com.example.apaga.ui.home.HomeActivity
import javax.inject.Inject

class BuyBagsFragment : BaseFragment(),BuyBagsContract.View {

    @Inject lateinit var presenter: BuyBagsContract.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        if (activityComponent != null) {
            activityComponent!!.inject(this)
            presenter.onAttach(this)
        }

        return super.onCreateView(inflater, container, savedInstanceState)

    }

    override fun setUp(view: View) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}