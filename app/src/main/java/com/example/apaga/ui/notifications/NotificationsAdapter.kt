package com.example.apaga.ui.notifications


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.apaga.R
import com.example.apaga.data.network.model.Notification
import com.example.apaga.data.network.model.NotificationType
import com.example.apaga.ui.base.BaseExpandableRecyclerViewAdapter
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder


class NotificationsAdapter(
        val context:Context,
        var groupList: List<NotificationType>
) :
        BaseExpandableRecyclerViewAdapter<NotificationsAdapter.NotificationsGroupHolder,
                NotificationsAdapter.NotificationsChildHolder>(groupList) {

     lateinit var childList:MutableList<Notification>
    inner class NotificationsChildHolder (itemView: View) : ChildViewHolder(itemView){
        var ttt : TextView =  itemView.findViewById(R.id.t)

         fun bindChild(position: Int){
             setChildData(position)
            ttt.text = childList[position].massage
        }
    }

    fun setGroupData(groupList:List<NotificationType>){
        this.groupList = groupList
        (groups as MutableList<NotificationType>).addAll(groupList)
        notifyGroupDataChanged()
        notifyItemChanged(1)
    }
    private fun setChildData(position: Int){
        childList = groupList!![position].items
    }

    inner class NotificationsGroupHolder (itemView: View) : GroupViewHolder(itemView){
        var ttt : TextView =  itemView.findViewById(R.id.tv_group)

         fun bindGroup(position: Int){
            ttt.text = groupList!![position]!!.title
        }
    }

    override fun onCreateGroupViewHolder(parent: ViewGroup, viewType: Int): NotificationsGroupHolder {
        return NotificationsGroupHolder(LayoutInflater.from(context)
                .inflate(R.layout.holder_notifications_group_item,parent,false))
    }

    override fun onCreateChildViewHolder(parent: ViewGroup, viewType: Int): NotificationsChildHolder {
       return NotificationsChildHolder(LayoutInflater.from(context)
               .inflate(R.layout.holder_notifications_child_item,parent,false))
    }

    override fun onBindChildViewHolder(holder: NotificationsChildHolder, flatPosition: Int, group: ExpandableGroup<*>?, childIndex: Int) {
        holder.bindChild(childIndex)
    }

    override fun onBindGroupViewHolder(holder: NotificationsGroupHolder, flatPosition: Int, group: ExpandableGroup<*>?) {
        holder.bindGroup(flatPosition)
    }


}
