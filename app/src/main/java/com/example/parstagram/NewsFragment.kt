package com.example.parstagram

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import com.example.myapplication.Data
import com.example.myapplication.DataAdapter
import okhttp3.Headers
import org.json.JSONException

private const val TAG = "MainActivity"
private const val STOCK_NEWS_URL = "https://api.polygon.io/v2/reference/news?apiKey=GOH_KWgFDh76oHih4WWtOvlmHx3y6zB0"
class NewsFragment : Fragment() {
    private val news = mutableListOf<News>()
    private lateinit var rvStockNews : RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_news, container, false)
        rvStockNews = root.findViewById(R.id.StockRVNews)
        val newsAdapter = this.context?.let { NewsAdapter(it,news) }
        rvStockNews.adapter = newsAdapter
        rvStockNews.layoutManager = LinearLayoutManager(this.context)

        val client = AsyncHttpClient()
        client.get(STOCK_NEWS_URL, object: JsonHttpResponseHandler(){
            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                response: String?,
                throwable: Throwable?
            ) {
                Log.e(TAG,"ON FAILURE $statusCode")
            }

            override fun onSuccess(statusCode: Int, headers: Headers?, json: JSON) {
                try {

                    val stockJsonArray = json.jsonObject.getJSONArray("results")
                    news.addAll(News.fromJsonArray(stockJsonArray))
                    newsAdapter?.notifyDataSetChanged()
                    Log.i(TAG, "News List $news")

                } catch(e: JSONException){
                    Log.e(TAG, "Encountered Exception $e")
                }
            }
        })
        return root
    }



}