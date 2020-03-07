package com.example.apaga.ui.base

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder

abstract class BaseExpandableRecyclerViewAdapter<
        DATA,
        GVH : BaseExpandableRecyclerViewAdapter.BaseGroupHolder<*>,
        CVH : BaseExpandableRecyclerViewAdapter.BaseChildHolder<*>
        >(groups: List<ExpandableGroup<*>?>?) : ExpandableRecyclerViewAdapter<GVH, CVH>(groups) {

    fun notifyGroupDataChanged() {
        expandableList.expandedGroupIndexes = BooleanArray(groups.size)
        for (i in groups.indices) {
            expandableList.expandedGroupIndexes[i] = false
        }
    }

    abstract fun setGroupData(data: DATA)

    abstract class BaseGroupHolder<G>(itemView: View) : GroupViewHolder(itemView) {
        abstract fun bindGroup(groupItem: G)
    }

    abstract class BaseChildHolder<C>(itemView: View) : ChildViewHolder(itemView) {
        abstract fun bindChild(childItem: C)
    }

}