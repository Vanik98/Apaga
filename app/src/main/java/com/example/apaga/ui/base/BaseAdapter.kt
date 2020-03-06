package com.example.apaga.ui.base

import android.view.View
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.apaga.ui.base.BaseAdapter.BaseHolder

abstract class BaseAdapter<T,U : BaseHolder> : RecyclerView.Adapter<U>() {

    abstract fun setData(data : T)

    abstract class BaseHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(position: Int)
    }
}