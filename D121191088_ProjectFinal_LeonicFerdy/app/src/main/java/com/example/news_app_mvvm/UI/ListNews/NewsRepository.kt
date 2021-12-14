package com.example.news_app_mvvm.UI.ListNews

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.news_app_mvvm.Model.Article
import com.example.news_app_mvvm.Model.DataNews
import com.example.news_app_mvvm.Model.DataNewsItem
import com.example.news_app_mvvm.Network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsRepository {

    private val mutableLiveData : MutableLiveData<ArrayList<Article>> = MutableLiveData<ArrayList<Article>>()

    fun getAllNewsFromApi() : MutableLiveData<ArrayList<Article>> {
        val api = NetworkConfig().api()

        api.getAllNews().enqueue(object : Callback<DataNewsItem> {
            override fun onResponse(call: Call<DataNewsItem>, response: Response<DataNewsItem>) {
                val dataNews = response.body()?.articles
                mutableLiveData.value = dataNews as ArrayList<Article>?
            }

            override fun onFailure(call: Call<DataNewsItem>, t: Throwable) {
                Log.e("FAILURE ALL NEWS", "ERROR : " + t)
            }

        })

        return mutableLiveData
    }

}