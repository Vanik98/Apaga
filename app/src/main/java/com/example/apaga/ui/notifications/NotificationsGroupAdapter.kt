package com.example.apaga.ui.notifications

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apaga.R
import com.example.apaga.data.network.model.NotificationsType
import com.example.apaga.ui.base.BaseAdapter
import javax.inject.Inject

class NotificationsGroupAdapter(val context:Context) : BaseAdapter<List<NotificationsType>, NotificationsGroupAdapter.NotificationsGroupHolder>(){
    private lateinit var listGroup :List<NotificationsType>
    @Inject
    lateinit var layoutManager: LinearLayoutManager
    @Inject
    lateinit var childAdapter: NotificationsChildAdapter

    override fun setData(listGroup: List<NotificationsType>) {
        this.listGroup = listGroup
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationsGroupHolder {
        return NotificationsGroupHolder(LayoutInflater.from(context)
                .inflate(R.layout.holder_notifications_group,parent,false))
    }

    override fun onBindViewHolder(holder:NotificationsGroupHolder, position: Int) {
        holder.bind(position)
    }
    override fun getItemCount(): Int {
        return listGroup.size
    }

    inner class NotificationsGroupHolder (itemView: View) : BaseHolder(itemView){
         val title : TextView =  itemView.findViewById(R.id.tv_title)
         val childRecyclerView : RecyclerView = itemView.findViewById(R.id.rv_notifications_child)

        override fun bind(position: Int){
            title.text = listGroup[position].title
            if(position == 0) {
                childRecyclerView.layoutManager = layoutManager
                childRecyclerView.adapter = childAdapter
            }
            childAdapter.setData(listGroup[position].notifications)
            childAdapter.notifyDataSetChanged()
        }
    }

}