package com.example.apaga.ui.buybags


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.apaga.R
import com.example.apaga.ui.base.BaseFragment
import javax.inject.Inject

class BuyBagsFragment : BaseFragment(), BuyBagsContract.View {

    @Inject
    lateinit var presenter: BuyBagsContract.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_buy_bugs, container, false)
        if (activityComponent != null) {
            activityComponent!!.inject(this)
            presenter.onAttach(this)
        }

        return view

    }

    override fun setUp(view: View) {
       view.setOnClickListener{}
    }

}