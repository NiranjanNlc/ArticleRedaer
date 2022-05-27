package com.example.articlereader.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.articlereader.databinding.SearchItemBinding
import com.example.articlereader.modal.data.Article

class TitleAdapter constructor(val context : Context, val itemClickListener: ItemClickListener):
    ListAdapter<Article,TitleAdapter.TitleListViewHolder>(ARTICLE_COMPARATOR) {
    interface ItemClickListener {
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

    inner class TitleListViewHolder(var items: SearchItemBinding) :
        RecyclerView.ViewHolder(items.root) {
        init {
            items.root.setOnClickListener {
                itemClickListener.onItemClick(items.article!!)
            }

        }
        fun bind(articleItem: Article) {
            items.article = articleItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TitleListViewHolder {
        println("On title view create ")
        val inflater = LayoutInflater.from(parent.context)
        val binding = SearchItemBinding.inflate(inflater)
        return TitleListViewHolder(binding)

    }

    override fun onBindViewHolder(holder: TitleAdapter.TitleListViewHolder, position: Int) {
        val articleItem = getItem(position)
        println(" see title .... " + articleItem.title)
        holder.bind(articleItem)
//        Glide.with(context).load(articleItem.titleImageUrl).into(holder.items.thumbnail)
//         holder.executePendingBindings()
    }
}
