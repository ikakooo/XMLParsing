package com.example.xmlparsing.models

 data class Table constructor(

 var tr: ArrayList<Tr>){

  data class Tr(
   var td: String)
 }
