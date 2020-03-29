package com.example.apaga.ui.buybags


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import com.example.apaga.R
import com.example.apaga.ui.base.BaseFragment
import com.example.apaga.ui.home.HomeActivity
import javax.inject.Inject

class BuyBagsFragment : BaseFragment(), BuyBagsContract.View {

    @Inject
    lateinit var presenter: BuyBagsContract.Presenter
    private lateinit var pay:ImageView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_buy_bugs, container, false)
        activityComponent!!.inject(this)
        presenter.onAttach(this)
        return view

    }

    override fun findViewsById(view:View) {
        pay = view.findViewById(R.id.buy_bags_iv_pay)
    }

    override fun setViewsOnClickListener() {
        pay.setOnClickListener{
            (activity as HomeActivity).navigate(R.id.nav_payment)
        }
    }

    override fun setViewsOptions() {
   print("aaa")
    }

}