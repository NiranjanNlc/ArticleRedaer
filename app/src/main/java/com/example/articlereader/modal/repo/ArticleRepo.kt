package com.example.articlereader.modal.repo

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.articlereader.modal.dao.ArticleDao
import com.example.articlereader.modal.data.Article

class ArticleRepo (private val articleDao: ArticleDao) {

    val allArticles: LiveData<List<Article>> = articleDao.getAlphabetizedWords()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(article: Article) {
        println(" inserted the article  ")
        articleDao.save(article)
        println(allArticles.getValue())
    }
}
