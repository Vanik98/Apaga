package com.example.apaga.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apaga.R
import com.example.apaga.ui.base.BaseFragment
import com.example.apaga.ui.home.HomeActivity
import com.example.apaga.ui.schedule.SchedulePickupContract
import com.example.apaga.utils.DialogUtils
import javax.inject.Inject

class DashboardFragment : BaseFragment(), DashboardContract.View{
    @Inject
    lateinit var presenter: DashboardContract.Presenter
    @Inject
    lateinit var layoutManager: LinearLayoutManager
    @Inject
    lateinit var adapter: DashboardAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var schedulePickupBtn:Button



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)
        activityComponent!!.inject(this)
        presenter.onAttach(this)
        return view
    }

    override fun findViewsById(view: View) {
        recyclerView = view.findViewById(R.id.dashboard_rv)
        schedulePickupBtn = view.findViewById(R.id.dashboard_btn_schedule_a_pickup)

    }

    override fun setViewsOnClickListener() {
        schedulePickupBtn.setOnClickListener{
            (activity as HomeActivity).navigate(R.id.nav_scheduled_pickup)
        }
    }

    override fun setViewsOptions() {
        val groupList : List<String> = arrayListOf("1","5","3","7")
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        adapter.setData(groupList)
    }


}
