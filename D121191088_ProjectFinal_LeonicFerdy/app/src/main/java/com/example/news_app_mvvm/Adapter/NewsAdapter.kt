package com.example.news_app_mvvm.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.news_app_mvvm.Model.Article
import com.example.news_app_mvvm.Model.DataNewsItem
import com.example.news_app_mvvm.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_news.view.*

class NewsAdapter (private val dataNewsItem: ArrayList<Article>, val listener : OnItemClickListener) : RecyclerView.Adapter<NewsAdapter.NewsHolder>() {

    interface OnItemClickListener {
        fun onItemClick(att : Article)
    }

    class NewsHolder(itemview : View) : RecyclerView.ViewHolder(itemview) {
        fun bind(itemNews : Article, listener: OnItemClickListener) {
            with(itemView) {
                Picasso.get().load("${itemNews.urlToImage}")
                    .into(imgView)
                source_name.text = "${itemNews.source.name}"
                titleView.text = "${itemNews.title}"
                itemView.setOnClickListener {
                    listener.onItemClick(itemNews)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_news,parent,false)
        return NewsHolder(view)
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        holder.bind(dataNewsItem[position], listener)
    }

    override fun getItemCount(): Int {
        return dataNewsItem.size
    }
}