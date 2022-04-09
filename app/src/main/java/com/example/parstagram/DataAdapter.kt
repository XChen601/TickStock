package com.example.myapplication

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.parstagram.R

class DataAdapter(private val context: Context, private val datas: List<Data>)
    : RecyclerView.Adapter<DataAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvName = itemView.findViewById<TextView>(R.id.tvSymbol)
        private val tvOpen = itemView.findViewById<TextView>(R.id.tvOpen)
        private val tvClose = itemView.findViewById<TextView>(R.id.tvClose)

        fun bind(data: Data) {
            tvName.text = data.name
            tvOpen.text = data.open
            tvClose.text = data.close

            if(data.open.toFloat() > data.close.toFloat()){
                tvOpen.setTextColor(Color.parseColor("#00cf26"))
                tvClose.setTextColor(Color.parseColor("#FF0000"))
            } else {
                tvClose.setTextColor(Color.parseColor("#00cf26"))
                tvOpen.setTextColor(Color.parseColor("#FF0000"))
            }



        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_data,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = datas[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

}
