package com.example.articlereader.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.articlereader.R
import com.example.articlereader.databinding.ActivityArticleListBinding
import com.example.articlereader.modal.database.ArticleDataBase
import com.example.articlereader.modal.repo.ArticleRepo
import com.example.articlereader.viewModal.ArticleViewModal
import com.example.articlereader.viewModal.ViewModalFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class ArticleList : AppCompatActivity(),ArticleAdapter.ItemClickListener
{
    private lateinit var binding:ActivityArticleListBinding
    private lateinit var sampleViewModal: ArticleViewModal
    private lateinit var adapter:ArticleAdapter
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
      //  setContentView(R.layout.activity_article_list)
       binding = DataBindingUtil.setContentView(this, R.layout.activity_article_list)
        Log.i("activityList","binding " )
        sampleViewModal = initialiseViewModal()
        adapter = ArticleAdapter(this,this)
        Log.i("activityList","adapter view data " )
        bindData()
        Log.i("activityList","binddata" )
        observeChange()
        Log.i("activityList","change objerved " )
        initRecyclerView()
        Log.i("activityList","recycler view " )
        initaliseRecipeList()
    }
    private fun initaliseRecipeList() {

    }

    private fun observeChange()
    {
        sampleViewModal.articlList.observe(this, {
            println(" this data " + sampleViewModal.articlList.value.toString())
            adapter.submitList(it)
        })
    }

    private fun initialiseViewModal(): ArticleViewModal {
        val applicationScope = CoroutineScope(SupervisorJob())
        val database = ArticleDataBase.getDatabase(this, applicationScope)
         val repository = ArticleRepo(database.reciepedDao())
        val sampleViewModal = ViewModalFactory(repository).create(ArticleViewModal::class.java)
        return sampleViewModal
    }
    private fun bindData()
    {
        binding.lifecycleOwner=this
    }
    private fun initRecyclerView()
    {
        print(" recycler view initiated")
        binding.recyclerView.layoutManager = GridLayoutManager(this,2) as RecyclerView.LayoutManager?
        // binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.adapter=   adapter
        binding.recyclerView.setItemViewCacheSize(4)
        adapter.submitList(sampleViewModal.articlList.value)
        // adapter.
    }
    override fun onItemClick(position: String)
    {
        
    }
}
