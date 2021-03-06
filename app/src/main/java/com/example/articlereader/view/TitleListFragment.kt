package com.example.articlereader.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
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
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_listing, container, false)
        viewModal= activity?.let { ViewModelProvider(it).get(SearchViewModal::class.java) }!!
        setAdapter()
        bindData()
        initRecyclerView()
        observechange()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observechange()
        }

    fun observechange() {
        viewModal.matchedarticle.observe(viewLifecycleOwner) {
            val modified:MutableList<Article> = it as MutableList
            Log.d(" observed ", modified.toString())
            personAdapter.submitList(modified)
        }
    }

    private fun setAdapter() {
        article = viewModal.matchedarticle.value!!
        Log.d(" set adapter ",article.toString())
        println(context==null)
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
        Log.d("recycler view initiated", article.toString())
//        binding.recyclerView.setItemViewCacheSize(4)
//        personAdapter.submitList(ArticleList.getArticles())
    }

    override fun onItemClick(article: Article) {
        val i = Intent(context,  ArticleReaderActivity ::class.java)
        println(" Nlc user here $article.toString()")
        i.putExtra("url",article.url)
        startActivity(i,null)
    }

}