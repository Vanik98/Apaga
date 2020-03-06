package com.example.apaga.ui.base

import android.view.View
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.apaga.ui.base.BaseAdapter.BaseHolder

abstract class BaseAdapter<T, U : BaseHolder> constructor(diffCallback: DiffUtil.ItemCallback<T>) : ListAdapter<T, U>(diffCallback) {

    abstract fun setData(t: T)

    abstract class BaseHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(position: Int)
    }
}