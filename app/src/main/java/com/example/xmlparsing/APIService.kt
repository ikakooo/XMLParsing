package com.example.xmlparsing

import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("rss.php")
    fun getExchangeRates(): Call<ExchangeDataModel.Rss>
}