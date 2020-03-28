package com.example.apaga.ui.payment


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.apaga.R
import com.example.apaga.ui.base.BaseFragment
import javax.inject.Inject

class PaymentFragment : BaseFragment(),PaymentContract.View {


    @Inject lateinit var presenter:PaymentContract.Presenter

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    override fun findViewsById(view: View) {
        view.setOnClickListener{}
    }


    override fun setViewsOptions() {
   print("")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        activityComponent!!.inject(this)
        presenter.onAttach(this)
        return inflater.inflate(R.layout.fragment_payment,container,false)
    }
}