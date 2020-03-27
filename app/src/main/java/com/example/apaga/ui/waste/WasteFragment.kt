package com.example.apaga.ui.waste

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apaga.R
import com.example.apaga.ui.base.BaseFragment
import javax.inject.Inject

class WasteFragment : BaseFragment(), WasteContract.View {

    @Inject
    lateinit var presenter:WasteContract.Presenter
    @Inject
    lateinit var layoutManager: LinearLayoutManager
    @Inject
    lateinit var adapter: WasteAdapter
    private lateinit var recyclerView: RecyclerView
    override fun setUp(view: View) {
        activityComponent!!.inject(this)
        presenter.onAttach(this)
    }

    override fun findViewsById(view: View) {
        recyclerView = view.findViewById(R.id.rv_waste)
    }

    override fun setViewsOnClickListener() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setViewsOptions() {
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        val groupList : List<String> = arrayListOf("asdasd","asdsad","Qwewq","Ee")
        adapter.setData(groupList)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_waste, container, false)
        actionWithViews(view)
        return view
    }

}
