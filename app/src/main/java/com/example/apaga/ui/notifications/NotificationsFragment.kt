package com.example.apaga.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apaga.R
import com.example.apaga.data.network.model.Notification
import com.example.apaga.data.network.model.NotificationType
import com.example.apaga.ui.base.BaseFragment
import javax.inject.Inject
import kotlin.concurrent.fixedRateTimer

class NotificationsFragment : BaseFragment(), NotificationsContract.View {
    @Inject
    lateinit var layoutManager: LinearLayoutManager
    @Inject
    lateinit var adapter: NotificationsAdapter
    @Inject
    lateinit var presenter: NotificationsContract.Presenter
    private lateinit var recyclerView:RecyclerView

    override fun setUp(view: View) {
        activityComponent!!.inject(this)
        presenter.onAttach(this)
    }

    override fun findViewsById(view: View) {
        recyclerView = view.findViewById(R.id.rv_notifications)  }

    override fun setViewsOnClickListener() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setViewsOptions() {
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        val groupList : List<NotificationType> = arrayListOf(
                NotificationType("Notification type1",
                        arrayListOf(Notification("hello my friend1"),
                                Notification("hello my friend2"))),
                NotificationType("Notification type2",
                        arrayListOf(Notification("Your pickup st-th is pendinghhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh conformation"),
                                Notification("Your pickup st-th is pending conformation"))),
                NotificationType("Notification type3",
                        arrayListOf(Notification("Your pickup st-th is pendinghhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh conformation"),
                                Notification("Your pickup st-th is pending conformation"))))
        adapter.setGroupData(groupList)
        adapter.expandAllGroups()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_notifications, container, false)
        actionWithViews(view)
        return view
    }


}
