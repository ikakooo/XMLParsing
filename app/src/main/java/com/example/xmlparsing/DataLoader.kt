package com.example.xmlparsing

import android.util.Log
import com.example.xmlparsing.Constants.BASE_URL_MOVIES
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DataLoader {
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL_MOVIES)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val service = retrofit.create(APIService::class.java)

    fun getRequestTopToday(
        callback: FutureCallbackMoviesBridge
    ) {
        val call = service.getPopular()
        call.enqueue(object : Callback<String> {
            override fun onFailure(call: Call<String>, t: Throwable) {
                callback.onFailure(t.message.toString())
            }

            override fun onResponse(
                call: Call<String>,
                response: Response<String>
            ) {
                response.body()?.let { callback.onResponse(it) }
                Log.d("topToday", response.body().toString())
            }

        })
    }



}