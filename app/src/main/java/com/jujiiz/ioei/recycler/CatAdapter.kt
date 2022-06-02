package com.jujiiz.ioei.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jujiiz.ioei.R
import com.jujiiz.ioei.entity.CatEntity

class CatAdapter(private val listener: CatListener) : RecyclerView.Adapter<CatViewHolder>() {
    var items: List<CatEntity> = emptyList()
        set(value) {
            field = value
            notifyItemRangeChanged(0, value.size)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_cat, parent, false)
        return CatViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}