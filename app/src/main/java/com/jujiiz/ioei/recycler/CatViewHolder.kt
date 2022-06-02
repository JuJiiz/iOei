package com.jujiiz.ioei.recycler

import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jujiiz.ioei.R
import com.jujiiz.ioei.entity.CatEntity

class CatViewHolder(
    private val view: View,
    private val listener: CatListener,
) : RecyclerView.ViewHolder(view) {

    fun bind(item: CatEntity) {
        // You can do like this
        val tvCatID = view.findViewById<TextView>(R.id.tvCatID)
        tvCatID.text = item.id.toString()

        // Or like this
        view.findViewById<TextView>(R.id.tvCatName)
            .apply { text = item.name }

        view.findViewById<ImageView>(R.id.imvCatColor)
            .apply {
                val color = Color.parseColor(item.colorHex)
                setBackgroundColor(color)
            }

        itemView.setOnClickListener { listener.onSelectCat(item) }
    }
}