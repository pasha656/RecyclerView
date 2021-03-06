package com.dolbik.pavel.kotlinadapter.adapters

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import com.dolbik.pavel.kotlinadapter.common.NewsItem
import com.dolbik.pavel.kotlinadapter.R
import com.dolbik.pavel.kotlinadapter.common.ViewType
import com.dolbik.pavel.kotlinadapter.common.ViewTypeDelegateAdapter
import com.dolbik.pavel.kotlinadapter.extention.inflate
import com.dolbik.pavel.kotlinadapter.extention.loadImg
import kotlinx.android.synthetic.main.item_news.view.*

class NewsDelegateAdapter : ViewTypeDelegateAdapter {


    private var onClick: OnClick? = null
    fun setOnClick(onClick: OnClick) { this.onClick = onClick }


    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val view = parent.inflate(R.layout.item_news)
        val holder = NewsViewHolder(view)
        view.setOnClickListener {
            val adapterPosition = holder.adapterPosition
            if (holder.adapterPosition != RecyclerView.NO_POSITION) {
                onClick?.onClickPosition(adapterPosition)
            }
        }
        return holder
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as NewsViewHolder
        holder.bind(item as NewsItem)
    }


    class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view){
        fun bind(item: NewsItem) = with(itemView) {
            imgThumbnail.loadImg(item.thumbnail)
            author.text = item.author
            title.text  = item.title
        }
    }

}
