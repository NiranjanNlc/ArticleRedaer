package com.example.articlereader.viewModal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.articlereader.modal.data.Article
import com.example.articlereader.modal.repo.ArticleRepo
import com.example.articlereader.utility.ArticleList
import kotlinx.coroutines.Job
import java.util.*
import kotlin.collections.ArrayList

class SearchViewModal ( repository: ArticleRepo) : ViewModel() {

    private lateinit var job: Job
    var articlList = ArticleList.getArticles()
    val searchString = MutableLiveData<String>()
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
        println(matchedarticle.value)
        }
}