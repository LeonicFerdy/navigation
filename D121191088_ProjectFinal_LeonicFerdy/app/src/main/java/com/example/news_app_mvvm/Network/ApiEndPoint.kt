package com.example.news_app_mvvm.Network

import com.example.news_app_mvvm.Model.DataNews
import com.example.news_app_mvvm.Model.DataNewsItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndPoint {

    @GET("v2/top-headlines?country=id&apiKey=319593da250b40b8a1dc7b11efab5ce5")
    fun getAllNews() : Call<DataNewsItem>

}