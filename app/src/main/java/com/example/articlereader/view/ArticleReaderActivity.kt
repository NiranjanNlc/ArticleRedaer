package com.example.articlereader.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.example.articlereader.databinding.FragmentArticleragmentBinding

class ArticleReaderActivity : AppCompatActivity() {

    private lateinit var binding: FragmentArticleragmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentArticleragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        print("jhhhhhhh")
        viewFragment(intent.extras?.get("url") as String)
    }

    private fun viewFragment( url :String) {
        println("miyyyyyyyyyyyyyyyyyy")
        binding.article.webViewClient = WebViewClient()
        // this will load the url of the website
        binding.article.loadUrl(url)
        // this will enable the javascript settings
        binding.article.settings.javaScriptEnabled = true
        println(" hello niranjn ")
        // if you want to enable zoom feature
        binding.article.settings.setSupportZoom(true)
    }
}