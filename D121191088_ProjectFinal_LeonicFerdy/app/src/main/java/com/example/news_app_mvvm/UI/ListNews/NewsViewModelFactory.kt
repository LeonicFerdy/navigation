package com.example.news_app_mvvm.UI.ListNews

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class NewsViewModelFactory (
    private val repository: NewsRepository
        ) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(NewsRepository::class.java).newInstance(repository)
    }
}