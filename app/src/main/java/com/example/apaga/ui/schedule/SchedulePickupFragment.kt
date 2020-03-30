package com.example.apaga.ui.schedule

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.apaga.R
import com.example.apaga.ui.base.BaseFragment
import com.example.apaga.ui.payment.PaymentContract
import com.example.apaga.ui.waste.WasteAdapter
import javax.inject.Inject

class SchedulePickupFragment : BaseFragment(),SchedulePickupContract.View {

    @Inject
    lateinit var presenter: SchedulePickupContract.Presenter
    @Inject
    lateinit var layoutManager: LinearLayoutManager
    @Inject
    lateinit var adapter: SchedulePickupAdapter
    private lateinit var recyclerView: RecyclerView
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
        val view = inflater.inflate(R.layout.fragment_schedule_pickup, container, false)
        val list : List<String> = arrayListOf("1","5","3","7")
        recyclerView = view.findViewById(R.id.schedule_pickup_rv_description)
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = adapter
        adapter.setData(list)
        recyclerView = view.findViewById(R.id.schedule_pickup_rv_bags)
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = adapter
        adapter.setData(list)
        return view
    }
}
