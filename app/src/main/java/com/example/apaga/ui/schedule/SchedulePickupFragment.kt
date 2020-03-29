package com.example.apaga.ui.schedule

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.apaga.R
import com.example.apaga.ui.base.BaseFragment
import com.example.apaga.ui.payment.PaymentContract
import javax.inject.Inject

class SchedulePickupFragment : BaseFragment(),SchedulePickupContract.View {

    @Inject
    lateinit var presenter: SchedulePickupContract.Presenter
    override fun findViewsById(view: View) {
    print("a")
    }

    override fun setViewsOptions() {
        print("a")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        activityComponent!!.inject(this)
        presenter.onAttach(this)
        return inflater.inflate(R.layout.fragment_schedule_pickup, container, false)
    }
}
