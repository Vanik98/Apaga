package com.example.apaga.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apaga.R
import com.example.apaga.ui.base.BaseFragment
import com.example.apaga.ui.notifications.NotificationsContract
import com.example.apaga.ui.waste.WasteListAdapter
import javax.inject.Inject

class DashboardFragment : BaseFragment(), DashboardContract.View{
    @Inject
    lateinit var presenter: DashboardContract.Presenter
    @Inject
    lateinit var layoutManager: LinearLayoutManager
    @Inject
    lateinit var adapter: DashboardAdapter

    override fun setUp(view: View) {
        view.setOnClickListener{}
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)
        activityComponent!!.inject(this)
        presenter.onAttach(this)
        val groupList : List<String> = arrayListOf("asdasd","asdsad","Qwewq","Ee")
        adapter.setData(groupList)
        return view
    }


}
