package com.example.news_app_mvvm.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class NetworkConfig {
    private val Base_Url = "https://newsapi.org/"
    private fun getNetwork() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(Base_Url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun api() : ApiEndPoint {
        return getNetwork().create(ApiEndPoint::class.java)
    }

}