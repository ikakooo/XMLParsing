package com.example.xmlparsing

import com.example.xmlparsing.models.RssDataModel
import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("rss.php")
    fun getExchangeRates(): Call<RssDataModel>
}