package com.example.apaga.ui.notifications

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import com.example.apaga.R
import com.example.apaga.ui.base.BaseAdapter

class NotificationsAdapter(context:Context) : BaseAdapter<String, NotificationsAdapter.NotificationsHolder>(diffCallback){

    companion object {
        private val diffCallback: DiffUtil.ItemCallback<String> = object : DiffUtil.ItemCallback<String>() {
            override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
//            return oldItem.getId() === newItem.getId()
                return true
            }

            override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
//            return oldItem.getId().equals(newItem.getId()) &&
//                    oldItem.getApiUrl().equals(newItem.getApiUrl())
//            //                    && oldItem.get() == newItem.getPriority();
                return false
            }
        }
    }

    override fun setData(t: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationsHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder:NotificationsHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    inner class NotificationsHolder (itemView: View) : BaseHolder(itemView){
        var ttt : TextView =  itemView.findViewById(R.id.t)
        override fun bind(position: Int){
            ttt.text = "uraaaaa hayer jan"
        }
    }
}