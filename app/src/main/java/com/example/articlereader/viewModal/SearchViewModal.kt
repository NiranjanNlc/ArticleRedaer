package com.example.articlereader.viewModal

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.articlereader.modal.data.Article
import com.example.articlereader.modal.repo.ArticleRepo
import com.example.articlereader.utility.ArticleList
import kotlinx.coroutines.Job

class SearchViewModal ( repository: ArticleRepo) : ViewModel() {

    private lateinit var job: Job
    var articlList = ArticleList.getArticles()
    var matchedarticle= MutableLiveData<List<Article>>()

    init {
        matchedarticle.value=articlList
        println( articlList.toString())
    }
    
    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }
    fun search(text: String?) {
        text?.let {
            matchedarticle.value = articlList.filter {
                it.title.contains(text,true)
            }
            }
        Log.d(" matched article ", matchedarticle.value.toString())
        }
}