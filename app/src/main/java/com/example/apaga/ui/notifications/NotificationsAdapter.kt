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

         fun bindChild(childItem : Notification){
            ttt.text = childItem.massage
        }
    }

    fun setGroupData(groupList:List<NotificationType>){
        this.groupList = groupList
        (groups as MutableList<NotificationType>).addAll(groupList)
        notifyGroupDataChanged()
        notifyDataSetChanged()
    }

    inner class NotificationsGroupHolder (itemView: View) : GroupViewHolder(itemView){
        var ttt : TextView =  itemView.findViewById(R.id.tv_group)

         fun bindGroup(nType: NotificationType){
            ttt.text = nType.title
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
        holder.bindChild(group!!.items[childIndex] as Notification)
    }

    override fun onBindGroupViewHolder(holder: NotificationsGroupHolder, flatPosition: Int, group: ExpandableGroup<*>?) {
        holder.bindGroup(group as NotificationType)
    }

    fun expandAllGroups() {
        groups.forEachIndexed { groupIndex, group ->
            if (isGroupExpanded(group).not()) {
                onGroupClick(expandableList.getFlattenedGroupIndex(groupIndex))
            }
        }
    }

}
