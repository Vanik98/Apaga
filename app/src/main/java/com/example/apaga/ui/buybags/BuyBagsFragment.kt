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
        actionWithViews(view)
        return view

    }

    override fun setUp(view: View) {
        activityComponent!!.inject(this)
        presenter.onAttach(this)
    }

    override fun findViewsById(view:View) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setViewsOnClickListener() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setViewsOptions() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}