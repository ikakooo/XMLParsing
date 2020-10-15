package com.example.xmlparsing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.xmlparsing.models.Channel
import com.example.xmlparsing.models.Money
import com.example.xmlparsing.models.RssDataModel
import com.example.xmlparsing.network_request.DataLoader
import com.example.xmlparsing.network_request.FutureCallbackExchangeBridge
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.delay

class MainActivity : AppCompatActivity() {
    private val exchangesTablesListOfRates = mutableListOf<Money>()
    private var exchangeRatesList = mutableListOf<Channel>()
    lateinit var exchangeRatesAdapter: ExchangeRatesAdapter
    private var cData = "0"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }


    private fun init() {

        RecyclerViewID.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        //RecyclerViewID.layoutManager = GridLayoutManager(this, 2)
        exchangeRatesAdapter = ExchangeRatesAdapter(exchangeRatesList,exchangesTablesListOfRates)
        RecyclerViewID.adapter = exchangeRatesAdapter
        getDaTa()
        Swipe_refresh.setOnRefreshListener {
            exchangesTablesListOfRates.clear()
            exchangeRatesList.clear()
            getDaTa()

            Swipe_refresh.isRefreshing =false
           // exchangeRatesAdapter.notifyDataSetChanged()
        }



    }

    private fun getDaTa() {
        DataLoader.getRequestExchangeRates(
            object : FutureCallbackExchangeBridge {

                override fun onResponse(response: RssDataModel) {
//                    allMoviesList.addAll( response.results.toMutableList())
//                    allMoviesAdapter.notifyDataSetChanged()
                    d("dsfdfsdf", response.toString())
                    response.channel.toMutableList()[0]!!.let {
                        exchangeRatesList.add(it)
                    }
                    cData = response.channel[0]?.item?.get(0)?.description.toString()
                    cDataConverter(cData)
                    //TextViewID.text = response.toString()
                    d("dsfdsdffsdf", cData)
//                    repeat(exchangesTablesListOfRates.size){exchangeRatesAdapter.notifyItemInserted(it)
//                        Thread.sleep(10)
//                    }
                    Thread.sleep(50)
                    exchangeRatesAdapter.notifyDataSetChanged()
                }

                override fun onFailure(error: String) {
                    d("dsfdfsdf", error)
                    // TextViewID.text = error
                }
            }
        )

    }

    fun cDataConverter(Cdata: String) {
        val exchangesTables = Cdata.split("<tr>", "</tr>")
        d("dsfddsfssdgfsdf", exchangesTables.toString())

        repeat(exchangesTables.size) {
            val exchangesTablesData =
                exchangesTables[it].split("<td>", "</td>", "<img  src=\"", "\"></td>")
            try {
                if (exchangesTablesData.size > 4) exchangesTablesListOfRates.add(
                    Money(
                        abbreviate = exchangesTablesData[1],
                        CountryValueName = exchangesTablesData[3],
                        value = exchangesTablesData[5],
                        IMGLink = exchangesTablesData[8],
                        changing = exchangesTablesData[10]
                    )
                )
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
        d("dsfddsfsdfsdgfsdf", exchangesTablesListOfRates.toString())

    }
}