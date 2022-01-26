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
      //  viewFragment("https://niranjannlc.blogspot.com/")
        viewFragment(intent.extras?.get("url") as String)
    }

    private fun viewFragment( url :String) {
        println("miyyyyyyyyyyyyyyyyyy")
        binding.article.webViewClient= WebViewClient()
        // this will load the url of the website
        binding.article.loadUrl(url)
        // this will enable the javascript settings
        binding.article.settings.javaScriptEnabled = true
        println(" hello niranjn ")
        // if you want to enable zoom feature
        binding.article.settings.setSupportZoom(true)
//        val transaction = getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.mainframe, Articleragment(url));
//        transaction.addToBackStack(null);
//        transaction.commit();
    }
//    // if you press Back button this code will work
//    override fun onBackPressed() {
//        // if your webview can go back it will go back
//        if (webView.canGoBack())
//            webView.goBack()
//        // if your webview cannot go back
//        // it will exit the application
//        else
//            super.onBackPressed()
//    }
}