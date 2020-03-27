package com.example.apaga.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apaga.R
import com.example.apaga.ui.base.BaseFragment
import javax.inject.Inject

class DashboardFragment : BaseFragment(), DashboardContract.View{
    @Inject
    lateinit var presenter: DashboardContract.Presenter
    @Inject
    lateinit var layoutManager: LinearLayoutManager
    @Inject
    lateinit var adapter: DashboardAdapter
    private lateinit var recyclerView: RecyclerView
    override fun setUp(view: View) {

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)
        activityComponent!!.inject(this)
        presenter.onAttach(this)
        actionWithViews(view)
        return view
    }

    override fun findViewsById(view: View) {
        recyclerView = view.findViewById(R.id.dashboard_rv)
    }

    override fun setViewsOnClickListener() {
    }

    override fun setViewsOptions() {
        val groupList : List<String> = arrayListOf("1","5","3","7")
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        adapter.setData(groupList)
    }


}
