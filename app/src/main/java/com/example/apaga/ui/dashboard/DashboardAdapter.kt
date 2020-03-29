package com.example.apaga.ui.dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apaga.R
import com.example.apaga.ui.base.BaseListAdapter
import com.example.apaga.ui.home.HomeActivity
import javax.inject.Inject

class DashboardAdapter @Inject constructor(
        var context: Context,
        var adapterChild: DashboardChildAdapter,
        var layoutManager: LinearLayoutManager
        ) :
        BaseListAdapter<String, DashboardAdapter.DashboardHolder>(DIFF_CALLBACK){
    lateinit var list:List<String>


    companion object{
        private val DIFF_CALLBACK: DiffUtil.ItemCallback<String> = object : DiffUtil.ItemCallback<String>() {
            override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }
        }
    }
    override fun setData(data: List<String>) {
        list = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardHolder {
       return DashboardHolder(LayoutInflater.from(context)
                .inflate(R.layout.holder_dashboard,parent,false))
    }

    override fun onBindViewHolder(holder: DashboardHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class DashboardHolder(itemView: View) : BaseListAdapter.BaseHolder<String>(itemView) {
        private lateinit var recyclerView: RecyclerView
        val editPickup: Button = itemView.findViewById(R.id.dashboard_btn_edit_pickup)
        override fun bind(item: String) {
            recyclerView = itemView.findViewById(R.id.dashboard_rv_pickup_description_value)
            recyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL, false)
            recyclerView.adapter = adapterChild
            adapterChild.setData(list)
            recyclerView = itemView.findViewById(R.id.dashboard_rv_bags_value)
            recyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL, false)
            recyclerView.adapter = adapterChild
            adapterChild.setData(list)
            editPickup.setOnClickListener{
                (context as HomeActivity).navigate(R.id.nav_scheduled_pickup)
            }
        }
    }
}