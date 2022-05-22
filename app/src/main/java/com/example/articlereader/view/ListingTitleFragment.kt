package com.example.articlereader.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.articlereader.R
import com.example.articlereader.modal.database.ArticleDataBase
import com.example.articlereader.modal.repo.ArticleRepo
import com.example.articlereader.viewModal.SearchViewModal
import com.example.articlereader.viewModal.ViewModalFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class ListingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_listing, container, false)
    }

    private fun initialiseViewModal(): SearchViewModal? {
        val applicationScope = CoroutineScope(SupervisorJob())
        val database = context?.let { ArticleDataBase.getDatabase(it, applicationScope) }
        val repository = database?.let { ArticleRepo(it.reciepedDao()) }
        return repository?.let { ViewModalFactory(it).create(SearchViewModal::class.java) }
    }

}