package com.example.newsexpresss.model

import com.google.gson.annotations.SerializedName

data class NewsModel (
    @SerializedName("urlToImage")
    val imageSrc: String,

    @SerializedName("title")
    val title: String)