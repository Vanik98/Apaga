package com.example.apaga.ui.notifications

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.apaga.R

class NotificationsAdapter : ListAdapter<String, NotificationsAdapter.NotificationsHolder> {

     constructor(diffCallback: DiffUtil.ItemCallback<String>) : super(diffCallback) {}
     constructor(config: AsyncDifferConfig<String>) : super(config) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationsHolder {
        return NotificationsHolder(LayoutInflater.from( parent.context).
                inflate(R.layout.holder_notifications, parent, false))
    }

    override fun onBindViewHolder(holder: NotificationsHolder, position: Int) {
        holder.bind(position)
    }

    class NotificationsHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
         var ttt : TextView =  itemView.findViewById(R.id.t)
            fun bind(position: Int){
                ttt.text = "uraaaaa hayer jan"
            }
    }
}