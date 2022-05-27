package com.example.articlereader.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.articlereader.R
import com.example.articlereader.databinding.FragmentArticleListBinding
import com.example.articlereader.modal.data.Article
import com.example.articlereader.modal.database.ArticleDataBase
import com.example.articlereader.modal.repo.ArticleRepo
import com.example.articlereader.viewModal.ArticleViewModal
import com.example.articlereader.viewModal.ViewModalFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class ArticleListFragment : Fragment(), ArticleAdapter.ItemClickListener {
    private lateinit var binding: FragmentArticleListBinding
    private lateinit var sampleViewModal: ArticleViewModal
    private lateinit var adapter: ArticleAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =DataBindingUtil.inflate(inflater, R.layout.fragment_article_list, container, false)
        sampleViewModal = initialiseViewModal()
        adapter = context?.let { ArticleAdapter(it, this) }!!
        Log.i("activityList", "adapter view data ")
        bindData()
        Log.i("activityList", "binddata")
        observeChange()
        Log.i("activityList", "change objerved ")
        initRecyclerView()
        Log.i("activityList", "recycler view ")
        return binding.root
    }
    private fun observeChange()
    {
        sampleViewModal.articlList.observe(viewLifecycleOwner, {
            println(" this data " + sampleViewModal.articlList.value.toString())
            adapter.submitList(it)
        })
    }

    private fun initialiseViewModal(): ArticleViewModal {
        val applicationScope = CoroutineScope(SupervisorJob())
        val database = ArticleDataBase.getDatabase(requireContext(), applicationScope)
        val repository = ArticleRepo(database.reciepedDao())
        return ViewModalFactory(repository).create(ArticleViewModal::class.java)
    }
    private fun bindData()
    {
        binding.lifecycleOwner=this
    }
    private fun initRecyclerView()
    {
        print(" recycler view initiated")
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        // binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.adapter=   adapter
        binding.recyclerView.setItemViewCacheSize(4)
        adapter.submitList(sampleViewModal.articlList.value)
        // adapter.
    }

    override fun onItemClick(article: Article) {
        val i = Intent(context,  ArticleReaderActivity ::class.java)
        println(" Nlc user here $article.toString()")
        i.putExtra("url",article.url)
        startActivity(i,null)
        //  finish()
    }
}