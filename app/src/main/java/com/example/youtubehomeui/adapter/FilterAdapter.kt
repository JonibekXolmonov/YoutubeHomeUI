package com.example.youtubehomeui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubehomeui.R
import com.example.youtubehomeui.model.Filter

class FilterAdapter(private val filters: ArrayList<Filter>) :
    RecyclerView.Adapter<FilterAdapter.VH>() {

    inner class VH(private val view: View) : RecyclerView.ViewHolder(view) {
        val tv_title: TextView = view.findViewById(R.id.tv_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH =
        VH(LayoutInflater.from(parent.context).inflate(R.layout.item_feed_filter, parent, false))

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.tv_title.text = filters[position].title
    }

    override fun getItemCount(): Int = filters.size
}