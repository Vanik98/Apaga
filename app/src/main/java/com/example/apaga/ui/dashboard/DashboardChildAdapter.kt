package com.example.apaga.ui.dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apaga.R
import com.example.apaga.ui.base.BaseListAdapter

class DashboardChildAdapter(private val context: Context) :
        BaseListAdapter<String, DashboardChildAdapter.DashboardChildHolder>(DIFF_CALLBACK){
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardChildHolder {
        return DashboardChildHolder(LayoutInflater.from(context)
                .inflate(R.layout.holder_dashboard_child,parent,false))
    }

    override fun onBindViewHolder(holder: DashboardChildHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class DashboardChildHolder(itemView: View) : BaseListAdapter.BaseHolder<String>(itemView) {
        private val imageView : ImageView = itemView.findViewById(R.id.dashboard_child_iv)
        private val textView:TextView = itemView.findViewById(R.id.dashboard_child_tv)
        override fun bind(item: String) {
        val imageID:Int = when(item){
            ""-> R.drawable.apaga_background
            "asda"-> R.drawable.logo_fb
            else -> R.drawable.logo_plastik
        }
            imageView.setImageResource(imageID)
            textView.text = item
        }
    }
}