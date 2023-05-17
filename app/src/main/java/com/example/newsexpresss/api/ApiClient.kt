package com.example.newsexpresss.api

import com.example.newsexpresss.model.NewsModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

class ApiClient {

    private val BASE_URL = "https://newsapi.org/v2/"

//    fun getInstance(): Retrofit{
    private val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    //}//


    val apiService = retrofit.create(ApiService::class.java)

}