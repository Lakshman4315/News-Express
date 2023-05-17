package com.example.newsexpresss.api

import com.example.newsexpresss.model.ArticlesModel
import com.example.newsexpresss.model.NewsModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("everything")
    suspend fun getNewsList(
        @Query("apikey") key: String = "a8e9021dd36d403089f9d98ba7682fe7"
    ): Response<ArticlesModel>
}