package com.example.articlereader.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doOnTextChanged
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.example.articlereader.R
import com.example.articlereader.databinding.ActivitySearchBinding
import com.example.articlereader.modal.database.ArticleDataBase
import com.example.articlereader.modal.repo.ArticleRepo
import com.example.articlereader.viewModal.SearchViewModal
import com.example.articlereader.viewModal.ViewModalFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob


class SearchActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySearchBinding
    private lateinit var sampleViewModal: SearchViewModal
    private lateinit var adapter:ArticleAdapter
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search)
        Log.i("activityList","binding " )
        sampleViewModal = initialiseViewModal()
        binding.inputSearch.addTextChangedListener{
            sampleViewModal.search(it.toString())
        }
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.articleContainer) as NavHostFragment
        navController = navHostFragment.navController
//        setupActionBarWithNavController(navController)
        binding.inputSearch.doOnTextChanged { text, start, before, count ->
            checkFragment()
            updateVieeModalValue()
             navController.navigate(R.id.action_articleListFragment_to_titleListFragment)
        }
    }

    private fun checkFragment() {

    }

    private fun updateVieeModalValue() {
    }

    private fun initialiseViewModal(): SearchViewModal {
        val applicationScope = CoroutineScope(SupervisorJob())
        val database = ArticleDataBase.getDatabase(this, applicationScope)
        val repository = ArticleRepo(database.reciepedDao())
        return ViewModalFactory(repository).create(SearchViewModal::class.java)
    }
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}