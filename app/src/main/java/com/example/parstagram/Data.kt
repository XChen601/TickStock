package com.example.myapplication

import org.json.JSONArray

data class Data(
    val name: String,
    val close: String,
    val open: String,

    ) {
    companion object {
        fun fromJsonArray(dataJsonArray: JSONArray): List<Data> {
            val datas = mutableListOf<Data>()
            for (i in 0 until dataJsonArray.length()) {
                val dataJson = dataJsonArray.getJSONObject(i)
                datas.add(
                    Data(
                        dataJson.getString("T"),
                        dataJson.getString("o"),
                        dataJson.getString("c")

                    )
                )
            }
            return datas
        }
    }
}