package com.example.apaga.ui.notifications

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import com.example.apaga.R
import com.example.apaga.ui.base.BaseAdapter

class NotificationsAdapter(val context:Context) : BaseAdapter<List<String>, NotificationsAdapter.NotificationsHolder>(diffCallback){
    private lateinit var list :List<String>
    companion object {
        private val diffCallback: DiffUtil.ItemCallback<List<String>> = object : DiffUtil.ItemCallback<List<String>>() {
            override fun areItemsTheSame(oldItem: List<String>, newItem: List<String>): Boolean {
            return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: List<String>, newItem: List<String>): Boolean {
            return oldItem == newItem
            }
        }
    }

    override fun setData(t: List<String>) {
        list = t
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationsHolder {
        return NotificationsHolder(LayoutInflater.from(context)
                .inflate(R.layout.holder_notifications,parent,false))
    }

    override fun onBindViewHolder(holder:NotificationsHolder, position: Int) {
        holder.bind(position)
    }
    override fun getItemCount(): Int {
        return list.size
    }

    inner class NotificationsHolder (itemView: View) : BaseHolder(itemView){
        var ttt : TextView =  itemView.findViewById(R.id.t)
        override fun bind(position: Int){
            ttt.text = list[position]
        }
    }
}