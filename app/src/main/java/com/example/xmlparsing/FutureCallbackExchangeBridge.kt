package com.example.xmlparsing

interface FutureCallbackExchangeBridge {
    fun onResponse(response: ExchangeDataModel.Rss)
    fun onFailure(error: String)
}