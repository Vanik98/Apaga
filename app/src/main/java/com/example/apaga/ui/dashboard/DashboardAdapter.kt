package com.example.apaga.ui.dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.apaga.R
import com.example.apaga.ui.base.BaseListAdapter

class DashboardAdapter(private val context: Context) :
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

    inner class DashboardHolder(itemView: View) : BaseListAdapter.BaseHolder<String>(itemView) {

        override fun bind(item: String) {

        }
    }
}