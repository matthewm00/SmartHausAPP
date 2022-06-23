package com.example.smarthausapp.ui.main

import android.content.ClipData
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.smarthausapp.R
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

class CustomAdapter constructor(private val dataSet: ArrayList<String>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_item, parent, false)
        return ViewHolder(view, myListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d(TAG, "Element $position set.")
        holder.textView.text = dataSet[position]
        val img: ImageView = holder.itemView.findViewById<ImageView>(R.id.imageView2)
        when (position + 1){
            1-> img.setImageResource(R.drawable.air_icon)
            2-> img.setImageResource(R.drawable.hoover_icon)
            3-> img.setImageResource(R.drawable.curtain_icon)
            4-> img.setImageResource(R.drawable.bedroom_icon)
            5-> img.setImageResource(R.drawable.fridge_icon)
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    private lateinit var myListener : onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        myListener = listener
    }

    class ViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView

        init {
            itemView.setOnClickListener { listener.onItemClick(adapterPosition)
            }
            textView = itemView.findViewById(R.id.textView)
        }
    }

    companion object {
        private const val TAG = "CustomAdapter"
    }
}