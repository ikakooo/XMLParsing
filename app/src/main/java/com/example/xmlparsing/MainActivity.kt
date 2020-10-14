package com.example.xmlparsing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import com.example.xmlparsing.models.RssDataModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getDaTa()
    }



    private fun getDaTa(){
        DataLoader.getRequestExchangeRates(
            object : FutureCallbackExchangeBridge {

                override fun onResponse(response: RssDataModel) {
//                    allMoviesList.addAll( response.results.toMutableList())
//                    allMoviesAdapter.notifyDataSetChanged()
                    d("dsfdfsdf",response.toString())
                    TextViewID.text = response.toString()
                }
                override fun onFailure(error: String) {
                    d("dsfdfsdf",error)
                    TextViewID.text = error
                }
            }
        )
    }
}