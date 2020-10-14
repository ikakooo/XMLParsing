package com.example.xmlparsing

import android.util.Log
import com.example.xmlparsing.Constants.BASE_URL_MOVIES
import com.example.xmlparsing.models.RssDataModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

object DataLoader {
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL_MOVIES)
        .addConverterFactory(SimpleXmlConverterFactory.create())
        .build()
    private val service = retrofit.create(APIService::class.java)

    fun getRequestExchangeRates(
        callback: FutureCallbackExchangeBridge
    ) {
        val call = service.getExchangeRates()
        call.enqueue(object : Callback<RssDataModel> {
            override fun onFailure(call: Call<RssDataModel>, t: Throwable) {
                callback.onFailure(t.message.toString())
                Log.d("topTodayonFailure", t.message.toString())
            }

            override fun onResponse(
                call: Call<RssDataModel>,
                response: Response<RssDataModel>
            ) {
                response.body()?.let { callback.onResponse(it) }
                Log.d("topTodayonResponse", response.body().toString())
            }

        })
    }



}