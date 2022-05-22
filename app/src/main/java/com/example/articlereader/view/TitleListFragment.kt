package com.example.articlereader.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.articlereader.R
import com.example.articlereader.databinding.FragmentListingBinding
import com.example.articlereader.modal.data.Article
import com.example.articlereader.modal.database.ArticleDataBase
import com.example.articlereader.modal.repo.ArticleRepo
import com.example.articlereader.viewModal.SearchViewModal
import com.example.articlereader.viewModal.ViewModalFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob


class TitleListFragment : Fragment() {

    private lateinit var binding: FragmentListingBinding
    private lateinit var viewModal: SearchViewModal
    private var article: ArrayList<Article> = arrayListOf()
    private var matchedarticle: ArrayList<Article> = arrayListOf()
    private var personAdapter: TitleAdapter  = TitleAdapter(article)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_listing, container, false)
        viewModal= initialiseViewModal() as SearchViewModal
        initRecyclerView()
        return binding.root
    }

    private fun initRecyclerView() {
        article = viewModal.articlList.value as ArrayList<Article>
        binding.recyclerView.adapter = personAdapter
    }

    private fun initialiseViewModal(): SearchViewModal? {
        val applicationScope = CoroutineScope(SupervisorJob())
        val database = context?.let { ArticleDataBase.getDatabase(it, applicationScope) }
        val repository = database?.let { ArticleRepo(it.reciepedDao()) }
        return repository?.let { ViewModalFactory(it).create(SearchViewModal::class.java) }
    }

}