package com.example.newsexpresss.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newsexpresss.api.ApiClient
import com.example.newsexpresss.api.ApiService
import com.example.newsexpresss.model.ArticlesModel
import com.example.newsexpresss.model.NewsModel

class Repository {

//    private  val newsLiveData = MutableLiveData<List<ArticlesModel>>()
//
//    val news: LiveData<List<ArticlesModel>>
//        get() = newsLiveData
//
//    suspend fun getNews(){
//        val result = apiService.getNewsList()
//        if(result?.body() != null){
//            newsLiveData.postValue(result.body())
//        }
//    }

    private val apiClient = ApiClient()


    suspend fun getNewsItem(): List<NewsModel>{
        val response = apiClient.apiService.getNewsList()
        return if (response.isSuccessful){
            val newsResponse = response.body()
            newsResponse?.articles ?: emptyList()
        }else{
            Log.d("messege","failed")
            emptyList()
        }
    }


}