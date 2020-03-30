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
import com.example.apaga.utils.DialogUtils
import javax.inject.Inject

class DashboardAdapter @Inject constructor(
        var context: Context,
        var adapterChild: DashboardChildAdapter,
        var layoutManager: LinearLayoutManager,
        var dialogUtils: DialogUtils
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
        val cancelPickup: Button = itemView.findViewById(R.id.dashboard_btn_cancel_pickup)
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
            cancelPickup.setOnClickListener{
                dialogUtils.showConfirmationDialog(context,
                        "Stop!",
                        "You are about to cancel or edit your pickup. Cancelling or editing more than 24 hours prior to the scheduled time is not a problem." +
                                "Cancelling or editing a pickup within 24 hours of your scheduled pickup may decrease your reliability rating and may cause slight to significant increases in future pickup costs." +
                                "Remember that you can leave your bags at a neighbour’s home or in front of your door if you are sure that they will not be stolen or lost. For more information please contact us at the coordinates below.",
                        View.OnClickListener {  },View.OnClickListener {  }
                        )
            }
        }
    }
}