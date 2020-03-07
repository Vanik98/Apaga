package com.example.apaga.ui.waste

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.apaga.R
import com.example.apaga.ui.base.BaseFragment
import com.example.apaga.ui.payment.PaymentContract
import javax.inject.Inject

class WasteFragment : BaseFragment(), WasteContract.View {

    @Inject
    lateinit var presenter:WasteContract.Presenter

    override fun setUp(view: View) {
        view.setOnClickListener{}
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        activityComponent!!.inject(this)
        presenter.onAttach(this)
        return inflater.inflate(R.layout.fragment_waste, container, false)
    }

}
