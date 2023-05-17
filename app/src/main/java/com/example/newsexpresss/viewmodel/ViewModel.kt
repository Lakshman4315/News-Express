package com.example.newsexpresss.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsexpresss.model.ArticlesModel
import com.example.newsexpresss.model.NewsModel
import com.example.newsexpresss.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val repository = Repository()
    private val _newsItems = MutableLiveData<List<NewsModel>>()

    val newsItems: LiveData<List<NewsModel>>
        get() = _newsItems


    fun fetchNewsItems(){
        viewModelScope.launch {
            val items = repository.getNewsItem()
            _newsItems.value = items
        }
    }

//    init {
//        viewModelScope.launch (Dispatchers.IO){
//            repository.getNews()
//        }
//    }
//
//    val news: LiveData<List<ArticlesModel>>
//    get() = repository.news

}