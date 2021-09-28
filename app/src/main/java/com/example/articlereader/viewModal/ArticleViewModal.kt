package com.example.articlereader.viewModal

import androidx.lifecycle.ViewModel
import com.example.articlereader.modal.repo.ArticleRepo
import com.example.articlereader.utility.Coroutines
import kotlinx.coroutines.Job

class ArticleViewModal ( private val repository: ArticleRepo) : ViewModel()
{

    private lateinit var job: Job
    val articlList =  repository.allArticles
    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized) job.cancel()
    }
    fun updateStatus()
    {
        println("Niranjan Lamichhane ")
//        job  = Coroutines.ioThenMain(
//            {repository.insert(Girls(name =_girl.value.toString()))},
//            { _girl.value = null }
//        )
    }
}