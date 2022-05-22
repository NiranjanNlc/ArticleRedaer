package com.example.articlereader.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.articlereader.databinding.SearchItemBinding
import com.example.articlereader.modal.data.Article

class TitleAdapter(
    var list: ArrayList<Article>
) : RecyclerView.Adapter<TitleAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            SearchItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(
            list[position]
        )
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(private var item:SearchItemBinding) : RecyclerView.ViewHolder(item.root) {
        fun bind(person: Article) {
            item.searchTitle.text = person.title
        }
    }
}