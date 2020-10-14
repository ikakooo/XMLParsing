package com.example.xmlparsing.models

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root


@Root(name = "rss", strict = false)
data class RssDataModel(
    @field:ElementList(entry = "channel", inline = true)
    @param:ElementList(name = "channel")
    var channel:  ArrayList<Channel?>
)
