package com.example.articlereader.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.articlereader.databinding.ArticleItemBinding
import com.example.articlereader.modal.data.Article

class ArticleAdapter constructor(val context : Context, val itemClickListener: ItemClickListener):
    ListAdapter<Article, ArticleAdapter.ArticleListViewHolder>(ARTICLE_COMPARATOR)
{
    interface ItemClickListener{
        fun onItemClick(article: Article)
    }
    companion object {
        val ARTICLE_COMPARATOR = object : DiffUtil.ItemCallback<Article>() {
            override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
                println(" item same ")
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
                print(" Content same ")
                return oldItem.title.equals(newItem.title)
            }
        }

    }
    inner  class ArticleListViewHolder(var items: ArticleItemBinding): RecyclerView.ViewHolder(items.root)
    {
        init {
            items.cardView.setOnClickListener{
                itemClickListener.onItemClick(items.article!!)
            }

        }
        fun bind(articleItem: Article)
        {
            items.article = articleItem
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleListViewHolder
    {
        println("On view create ")
        val inflater = LayoutInflater.from(parent.context)
        val binding = ArticleItemBinding.inflate(inflater)
        return ArticleListViewHolder(binding)

    }
    override fun onBindViewHolder(holder: ArticleListViewHolder, position: Int)
    {
        val articleItem = getItem(position)
        println( " see thid " + articleItem.title)
        holder.bind(articleItem)
        Glide.with(context).load(articleItem.titleImageUrl).into(holder.items.thumbnail)
        // holder.executePendingBindings()
    }

}