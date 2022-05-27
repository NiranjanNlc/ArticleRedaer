package com.example.articlereader.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
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
    private lateinit var article: List<Article>
    private lateinit var personAdapter: TitleAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_listing, container, false)
        viewModal= initialiseViewModal() as SearchViewModal
        bindData()
        initRecyclerView()
        viewModal.matchedarticle.observe(viewLifecycleOwner,{
            binding.recyclerView.adapter = TitleAdapter(it )
        })
        return binding.root
    }

    private fun initialiseViewModal(): SearchViewModal? {
        val applicationScope = CoroutineScope(SupervisorJob())
        val database = context?.let { ArticleDataBase.getDatabase(it, applicationScope) }
        val repository = database?.let { ArticleRepo(it.reciepedDao()) }
        return repository?.let { ViewModalFactory(it).create(SearchViewModal::class.java) }
    }

    private fun bindData()
    {
        binding.lifecycleOwner=this
    }
    private fun initRecyclerView()
    {
        article = viewModal.matchedarticle.value!!
        print(article)
        personAdapter = TitleAdapter(article)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = personAdapter
        print(" recycler view initiated")
        binding.recyclerView.setItemViewCacheSize(4)
    }

}