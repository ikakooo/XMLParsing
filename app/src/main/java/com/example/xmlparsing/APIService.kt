package com.example.xmlparsing

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET("3/movie/popular")
    fun getPopular(): Call<String>

}