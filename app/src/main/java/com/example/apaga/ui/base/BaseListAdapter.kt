package com.example.apaga.ui.base

import android.view.View
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.apaga.ui.base.BaseListAdapter.BaseHolder

abstract class BaseListAdapter<T, U : BaseHolder<*>> constructor(diffCallback: DiffUtil.ItemCallback<T>) : ListAdapter<T, U>(diffCallback) {

    abstract fun setData(data: List<T>)

    abstract class BaseHolder<I>(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(item: I)
    }
}