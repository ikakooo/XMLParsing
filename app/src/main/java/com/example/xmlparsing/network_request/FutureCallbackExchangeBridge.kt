package com.example.xmlparsing.network_request

import com.example.xmlparsing.models.RssDataModel

interface FutureCallbackExchangeBridge {
    fun onResponse(response: RssDataModel)
    fun onFailure(error: String)
}