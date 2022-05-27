package com.example.articlereader.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
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


class TitleListFragment : Fragment() , TitleAdapter.ItemClickListener{

    private lateinit var binding: FragmentListingBinding
    private lateinit var viewModal: SearchViewModal
    private lateinit var article: List<Article>
    private lateinit var personAdapter: TitleAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_listing, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModal= initialiseViewModal() as SearchViewModal
        setAdapter()
        bindData()
        observechange()
        initRecyclerView()
    }

    private fun observechange() {
        viewModal.matchedarticle.observe(viewLifecycleOwner, {
            Log.d(" observed ", " why this why ")
            personAdapter.submitList(it)
        })
    }

    private fun setAdapter() {
        article = viewModal.matchedarticle.value!!
        Log.d(" set adapter ",article.toString())
        personAdapter = context?.let { TitleAdapter(it, this) }!!
    }

    private fun initialiseViewModal(): SearchViewModal? {
        val applicationScope = CoroutineScope(SupervisorJob())
        val database = context?.let { ArticleDataBase.getDatabase(it, applicationScope) }
        val repository = database?.let { ArticleRepo(it.reciepedDao()) }
        Log.d(" viewmodal ", " initialising ")
        return repository?.let { ViewModalFactory(it).create(SearchViewModal::class.java) }
    }

    private fun bindData()
    {
        binding.lifecycleOwner=this
        Log.d("bindData .. ",article.toString())
    }
    private fun initRecyclerView()
    {
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = personAdapter
        Log.d("recycler view initiated", " hello ")
        binding.recyclerView.setItemViewCacheSize(4)
        personAdapter.submitList(viewModal.matchedarticle.value)
    }

    override fun onItemClick(article: Article) {
        val i = Intent(context,  ArticleReaderActivity ::class.java)
        println(" Nlc user here $article.toString()")
        i.putExtra("url",article.url)
        startActivity(i,null)
    }

}