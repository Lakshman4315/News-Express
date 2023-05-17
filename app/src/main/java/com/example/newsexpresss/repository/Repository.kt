package com.example.newsexpresss.repository

import android.util.Log
import com.example.newsexpresss.api.Api.apiService
import com.example.newsexpresss.model.Article

class Repository {

    suspend fun getNewsItem(): List<Article> {
        val response = apiService.getNewsList()
        return if(response.isSuccessful){
            response.body()?.articles ?: emptyList()
        }else{
            Log.d("messege","error")
            emptyList()
        }

    }

}