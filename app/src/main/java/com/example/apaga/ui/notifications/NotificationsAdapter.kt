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

class NotificationsAdapter(
        val context:Context,
        var groupList: List<NotificationType>
) : BaseExpandableRecyclerViewAdapter<
        List<NotificationType>,
        NotificationsAdapter.NotificationsGroupHolder,
        NotificationsAdapter.NotificationsChildHolder
        >(groupList) {

    override fun setGroupData(groupList:List<NotificationType>){
        this.groupList = groupList
        (groups as MutableList<NotificationType>).addAll(groupList)
        notifyGroupDataChanged()
        notifyDataSetChanged()
    }

    override fun onCreateGroupViewHolder(parent: ViewGroup, viewType: Int): NotificationsGroupHolder {
        return NotificationsGroupHolder(LayoutInflater.from(context)
                .inflate(R.layout.holder_notifications_group,parent,false))
    }

    override fun onCreateChildViewHolder(parent: ViewGroup, viewType: Int): NotificationsChildHolder {
       return NotificationsChildHolder(LayoutInflater.from(context)
               .inflate(R.layout.holder_notifications_child,parent,false))
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

    inner class NotificationsGroupHolder (itemView: View) : BaseGroupHolder<NotificationType>(itemView){
        var ttt : TextView =  itemView.findViewById(R.id.notifications_group_tv_title)

        override fun bindGroup(groupItem: NotificationType){
            ttt.text = groupItem.title
        }
    }

    inner class NotificationsChildHolder (itemView: View) : BaseChildHolder<Notification>(itemView){
        var ttt : TextView =  itemView.findViewById(R.id.notifications_child_tv_information)
        init {
            ttt.setSelected(true)
        }
        override fun bindChild(childItem : Notification){
            ttt.text = childItem.massage
        }
    }
}
