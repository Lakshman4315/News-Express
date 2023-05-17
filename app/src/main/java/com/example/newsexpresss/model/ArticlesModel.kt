package com.example.newsexpresss.model

import com.google.gson.annotations.SerializedName

data class ArticlesModel(

    @SerializedName("articles")
    val articles: List<NewsModel>

    )
