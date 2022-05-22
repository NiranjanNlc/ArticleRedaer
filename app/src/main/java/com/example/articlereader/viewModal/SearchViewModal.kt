package com.example.articlereader.viewModal

import androidx.lifecycle.ViewModel
import com.example.articlereader.modal.repo.ArticleRepo
import kotlinx.coroutines.Job

class SearchViewModal ( repository: ArticleRepo) : ViewModel() {

    private lateinit var job: Job
    val articlList = repository.allArticles
    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }

}