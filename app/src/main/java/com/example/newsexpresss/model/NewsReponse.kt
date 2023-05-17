package com.example.newsexpresss.model

data class NewsApiModelClass(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)