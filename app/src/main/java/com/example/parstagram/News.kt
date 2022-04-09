package com.example.parstagram

import org.json.JSONArray

data class News (
    val id: String,
    val article_url: String,
    val author: String,
    val title: String,
) {
    companion object{
        fun fromJsonArray(stockJsonArray: JSONArray): List<News> {
            val news = mutableListOf<News>()
            for(i in 0 until stockJsonArray.length()) {
                val newsJson = stockJsonArray.getJSONObject(i)
                news.add(
                    News(
                        newsJson.getString("id"),
                        newsJson.getString("article_url"),
                        newsJson.getString("author"),
                        newsJson.getString("title")
                    )
                )
            }
            return news
        }
    }
}