package com.example.xmlparsing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getDaTa()
    }



    fun getDaTa(){
        DataLoader.getRequestExchangeRates(
            object : FutureCallbackExchangeBridge {

                override fun onResponse(response: ExchangeDataModel.Rss) {
//                    allMoviesList.addAll( response.results.toMutableList())
//                    allMoviesAdapter.notifyDataSetChanged()
                    d("dsfdfsdf",response.toString())
                }
                override fun onFailure(error: String) {
                    d("dsfdfsdf",error)
                }
            }
        )
    }
}