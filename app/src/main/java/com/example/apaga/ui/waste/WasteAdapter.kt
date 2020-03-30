package com.example.apaga.ui.waste

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import com.example.apaga.R
import com.example.apaga.ui.base.BaseListAdapter

class WasteAdapter(private val context:Context): BaseListAdapter<String, WasteAdapter.WasteHolder>(DIFF_CALLBACK) {
    lateinit var list:List<String>
    override fun setData(data: List<String>) {
        list = data
    }
    companion object{
        private val DIFF_CALLBACK: DiffUtil.ItemCallback<String> = object : DiffUtil.ItemCallback<String>() {
            override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WasteHolder {
        return WasteHolder(LayoutInflater.from(context)
                .inflate(R.layout.holder_waste,parent,false))
    }

    override fun onBindViewHolder(holder: WasteHolder, position: Int) {
            holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class WasteHolder(itemView: View) : BaseListAdapter.BaseHolder<String>(itemView) {
        val textView:TextView = itemView.findViewById(R.id.waste_tv_text)
        val imageView:ImageView = itemView.findViewById(R.id.waste_iv_image)
        override fun bind(item: String) {
            textView.text  = item
            when(item) {
                "Plastic"->imageView.setImageResource(R.drawable.logo_plastik)
                "Paper"->imageView.setImageResource(R.drawable.logo_paper)
                "Glass"->imageView.setImageResource(R.drawable.logo_glass)
            }
        }
    }
}