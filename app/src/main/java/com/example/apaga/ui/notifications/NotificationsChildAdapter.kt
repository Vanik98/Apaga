package com.example.apaga.ui.notifications

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.apaga.R
import com.example.apaga.data.network.model.Notification
import com.example.apaga.ui.base.BaseAdapter

class NotificationsChildAdapter(val context: Context) : BaseAdapter<List<Notification>, NotificationsChildAdapter.NotificationsChildHolder>() {
    lateinit var childList : List<Notification>

    override fun setData(data: List<Notification>) {
        childList = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationsChildHolder {
        return NotificationsChildHolder(LayoutInflater.from(context)
                .inflate(R.layout.holder_notifications_child,parent,false))  }

    override fun getItemCount(): Int {
        return childList.size
    }

    override fun onBindViewHolder(holder: NotificationsChildHolder, position: Int) {
        holder.bind(position)
    }

    inner class NotificationsChildHolder (itemView: View) : BaseAdapter.BaseHolder(itemView){
        val title : TextView =  itemView.findViewById(R.id.tv_child)
        override fun bind(position: Int){
            title.text = childList[position].message

        }
    }

}