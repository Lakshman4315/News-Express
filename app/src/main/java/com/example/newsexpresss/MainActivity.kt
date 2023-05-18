package com.example.newsexpresss

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsexpresss.adpater.RecyclerViewAdapter
import com.example.newsexpresss.model.NewsModel
import com.example.newsexpresss.model.NewsReponse
import com.example.newsexpresss.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

        var newsArray = ArrayList<NewsModel>()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerViewAdapter = RecyclerViewAdapter(newsArray)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.newsItem.observe( this, Observer{

            for(news in it){
                newsArray.add(NewsModel(news.urlToImage.toString(),news.title.toString()))
            }
        })

        mainViewModel.fetchNewsItems("us")
    }


    private fun init(){
        recyclerView = findViewById(R.id.recyclerView)
    }


}