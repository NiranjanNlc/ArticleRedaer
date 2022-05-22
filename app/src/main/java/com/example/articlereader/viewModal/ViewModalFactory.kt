package com.example.articlereader.viewModal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.articlereader.modal.repo.ArticleRepo

class ViewModalFactory(private val repository: ArticleRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        println(" Inn view modal factory")
        if (modelClass.isAssignableFrom(ArticleViewModal::class.java)) {
            println("Assighnable class")
            @Suppress("UNCHECKED_CAST")
            return ArticleViewModal(repository) as T
        }
        else if (modelClass.isAssignableFrom(SearchViewModal::class.java)) {
            println("Assighnable class")
            @Suppress("UNCHECKED_CAST")
            return SearchViewModal(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}