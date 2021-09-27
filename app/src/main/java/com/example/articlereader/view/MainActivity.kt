package com.example.articlereader.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.articlereader.R
import com.example.binding.articlereader.view.Articleragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewFragment("https://niranjannlc.blogspot.com/")
    }

    private fun viewFragment( url :String) {
        val transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.mainframe, Articleragment(url));
        transaction.addToBackStack(null);
        transaction.commit();
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