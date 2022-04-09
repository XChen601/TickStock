package com.example.parstagram

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsAdapter(private val context: Context, private val news: List<News>)
    : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.stock_news,parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val stocknew = news[position]
        holder.bind(stocknew)
    }

    override fun getItemCount() = news.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val stockTitle = itemView.findViewById<TextView>(R.id.stockTitle)
        private val stockAuthor = itemView.findViewById<TextView>(R.id.authorName)

        fun bind(stocknew: News) {
            stockTitle.text = stocknew.title
            stockAuthor.text = stocknew.author


        }
    }

}
