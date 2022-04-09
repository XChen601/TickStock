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

private const val TAG = "MainActivity"
private const val poly = "https://api.polygon.io/v2/aggs/grouped/locale/us/market/stocks/2020-10-14?adjusted=true&apiKey=GOH_KWgFDh76oHih4WWtOvlmHx3y6zB0"
class FeedFragment : Fragment() {
    private val datas = mutableListOf<Data>()
    private lateinit var rvDatas : RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_feed, container, false)
        rvDatas = root.findViewById(R.id.rvDatas)
        val dataAdapter = this.context?.let { DataAdapter(it,datas) }
        rvDatas.adapter = dataAdapter
        rvDatas.layoutManager = LinearLayoutManager(this.context)

        val client = AsyncHttpClient()
        client.get(poly, object: JsonHttpResponseHandler(){
            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                response: String?,
                throwable: Throwable?
            ) {
                Log.e(TAG,"ON FAILURE $statusCode")
            }

            override fun onSuccess(statusCode: Int, headers: Headers?, json: JSON) {
                Log.e(TAG,"ON SUCCESS $json")
                val dataJsonArray = json.jsonObject.getJSONArray("results")
                datas.addAll(Data.fromJsonArray(dataJsonArray))
                dataAdapter?.notifyDataSetChanged()
                Log.i(TAG,"DATA LIST $datas")
            }
        })
        return root
    }



}