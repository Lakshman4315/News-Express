package com.example.newsexpresss.adpater

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsexpresss.R
import com.example.newsexpresss.model.NewsModel

class RecyclerViewAdapter(private val newsList: List<NewsModel>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val newsImage: ImageView
        val newsTitle: TextView

        init {
            newsImage = view.findViewById(R.id.newsImage)
            newsTitle = view.findViewById(R.id.newsTitle)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.news_recylerview_item,parent,false))
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.newsTitle.text = newsList[position].title

    }
}