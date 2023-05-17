package com.example.newsexpresss

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsexpresss.adpater.RecyclerViewAdapter
import com.example.newsexpresss.api.ApiClient
import com.example.newsexpresss.api.ApiService
import com.example.newsexpresss.model.NewsModel
import com.example.newsexpresss.repository.Repository
import com.example.newsexpresss.viewmodel.MainViewModel
import com.example.newsexpresss.viewmodel.MainViewModelFactory
import okhttp3.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    private lateinit var newsList: List<NewsModel>

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerViewAdapter = RecyclerViewAdapter(newsList)
//        val apiService = ApiClient().apiService;
//        val repository = Repository(apiService)


        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.newsItems.observe( this, Observer{

            Log.d("Result", it.size.toString())

//            if(it!=null){
//
//            }else{
//                Toast.makeText(this,it.indexOf(0),Toast.LENGTH_SHORT).show();
//            }
        })

    }

    private fun init(){
        recyclerView = findViewById(R.id.recyclerView)
    }


}