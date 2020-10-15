package com.example.xmlparsing.models

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "channel", strict = false)
data class Channel constructor(
    @field:Element(name = "title")
    @param:Element(name = "title")
    var title: String?,
    @field:Element(name = "link")
    @param:Element(name = "link")
    var link: String?,
    @field:Element(name = "description")
    @param:Element(name = "description")
    var description: String?,
    @field:Element(name = "language")
    @param:Element(name = "language")
    var language: String?,
    @field:Element(name = "copyright")
    @param:Element(name = "copyright")
    var copyright: String?,
    @field:Element(name = "pubDate")
    @param:Element(name = "pubDate")
    var pubDate: String?,
    @field:Element(name = "lastBuildDate")
    @param:Element(name = "lastBuildDate")
    var lastBuildDate: String?,
    @field:Element(name = "managingEditor")
    @param:Element(name = "managingEditor")
    var managingEditor: String?,
    @field:Element(name = "webMaster")
    @param:Element(name = "webMaster")
    var webMaster: String?,
    @field:ElementList(entry = "item", inline = true)
    @param:ElementList(name = "item")
    var item: ArrayList<Item?>
)