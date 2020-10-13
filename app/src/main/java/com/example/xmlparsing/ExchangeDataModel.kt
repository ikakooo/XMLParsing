package com.example.xmlparsing

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "ikakoo",strict = false)
data class ExchangeDataModel(val rss: ArrayList<Rss?>) {

    data class Rss(
        @ElementList(entry = "channel", inline = true)
        val channel: ArrayList<Channel?>,
        val version: String?
    ) {

        data class Channel(
            val copyright: String?,
            @ElementList(entry = "item", inline = true)
            val item: ArrayList<Item?>,
            val lastBuildDate: String?,
            val link: String?,
            val description: String?,
            val language: String?,
            val title: String?,
            val managingEditor: String?,
            val pubDate: String?,
            val webMaster: String?
        ) {
            data class Item(
                val link: String?,
                val description: String?,
                val guid: String?,
                val title: String?,
                val pubDate: String?
            )

        }

    }
}






