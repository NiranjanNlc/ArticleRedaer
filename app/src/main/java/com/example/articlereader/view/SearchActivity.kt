package com.example.articlereader.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.articlereader.R
import com.example.articlereader.databinding.ActivityArticleListBinding
import com.example.articlereader.databinding.ActivitySearchBinding
import com.example.articlereader.modal.database.ArticleDataBase
import com.example.articlereader.modal.repo.ArticleRepo
import com.example.articlereader.viewModal.ArticleViewModal
import com.example.articlereader.viewModal.SearchViewModal
import com.example.articlereader.viewModal.ViewModalFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class SearchActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySearchBinding
    private lateinit var sampleViewModal: SearchViewModal
    private lateinit var adapter:ArticleAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_search)
        Log.i("activityList","binding " )
        sampleViewModal = initialiseViewModal()
    }

    private fun initialiseViewModal(): SearchViewModal {
        val applicationScope = CoroutineScope(SupervisorJob())
        val database = ArticleDataBase.getDatabase(this, applicationScope)
        val repository = ArticleRepo(database.reciepedDao())
        return ViewModalFactory(repository).create(SearchViewModal::class.java)
    }

}