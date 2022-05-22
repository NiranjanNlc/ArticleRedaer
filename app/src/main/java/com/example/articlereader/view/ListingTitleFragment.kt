package com.example.articlereader.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.articlereader.R
import com.example.articlereader.databinding.FragmentListingBinding
import com.example.articlereader.modal.database.ArticleDataBase
import com.example.articlereader.modal.repo.ArticleRepo
import com.example.articlereader.viewModal.SearchViewModal
import com.example.articlereader.viewModal.ViewModalFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class ListingFragment : Fragment() {

    private lateinit var binding: FragmentListingBinding
    private lateinit var viewModal: SearchViewModal
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_listing, container, false)
        viewModal= initialiseViewModal() as SearchViewModal
        viewModal.searchString.observe(viewLifecycleOwner,
            {

            })
        return binding.root
    }

    private fun initialiseViewModal(): SearchViewModal? {
        val applicationScope = CoroutineScope(SupervisorJob())
        val database = context?.let { ArticleDataBase.getDatabase(it, applicationScope) }
        val repository = database?.let { ArticleRepo(it.reciepedDao()) }
        return repository?.let { ViewModalFactory(it).create(SearchViewModal::class.java) }
    }

}