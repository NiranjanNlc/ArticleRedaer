package com.example.binding.articlereader.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import com.example.articlereader.R
import com.example.articlereader.databinding.FragmentArticleragmentBinding


class Articleragment(val url : String) : Fragment() {

    private lateinit var binding: FragmentArticleragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {   
        binding = FragmentArticleragmentBinding.inflate(layoutInflater)
        setUpWebView()
        return inflater.inflate(R.layout.fragment_articleragment, container, false)
    }

    private fun setUpWebView() {
        // WebViewClient allows you to handle
        // onPageFinished and override Url loading.
        binding.article.webViewClient= WebViewClient()
        // this will load the url of the website
        binding.article.loadUrl(url)
        // this will enable the javascript settings
        binding.article.settings.javaScriptEnabled = true
         print(" hello niranjn ")
        // if you want to enable zoom feature
        binding.article.settings.setSupportZoom(true)
    }

    }

