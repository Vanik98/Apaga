package com.example.apaga.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apaga.R
import com.example.apaga.ui.base.BaseFragment
import javax.inject.Inject

class NotificationsFragment : BaseFragment(), NotificationsContract.View {
    @Inject
    lateinit var layoutManager: LinearLayoutManager
    @Inject
    lateinit var adapter: NotificationsAdapter
    private lateinit var recyclerView:RecyclerView

    override fun setUp(view: View) {
        view.setOnClickListener {}
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_notifications, container, false)
        recyclerView = view.findViewById(R.id.rv_notifications)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        return view
    }


}
