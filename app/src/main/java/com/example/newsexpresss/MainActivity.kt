package com.example.newsexpresss

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.newsexpresss.adpater.RecyclerViewAdapter
import com.example.newsexpresss.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
//    private lateinit var newsList: List<NewsModel>

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerViewAdapter = RecyclerViewAdapter(newsList)
//        val apiService = ApiClient().apiService;
//        val repository = Repository(apiService)

//        val repository = Repository()
//        val viewModelProviderFactory = MainViewModelFactory(repository)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.newsItem.observe( this, Observer{

            Log.d("Result", it.size.toString())
        })

        mainViewModel.fetchNewsItems()
    }

    private fun init(){
        recyclerView = findViewById(R.id.recyclerView)
    }


}