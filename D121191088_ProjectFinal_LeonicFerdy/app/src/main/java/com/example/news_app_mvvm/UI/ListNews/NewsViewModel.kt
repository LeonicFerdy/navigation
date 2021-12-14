package com.example.news_app_mvvm.UI.ListNews

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.news_app_mvvm.Model.Article

class NewsViewModel (
    private val repository : NewsRepository
    ) : ViewModel()
{
    private var _articles = ArrayList<Article>()
    val article : ArrayList<Article>
        get() = _articles

    fun getAllNewsFromRepo() : MutableLiveData<ArrayList<Article>> {
        return repository.getAllNewsFromApi()
    }

    override fun onCleared() {
        super.onCleared()
        _articles.clear()
    }

}