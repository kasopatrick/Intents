package com.example.morningintents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.webkit.WebChromeClient
import android.webkit.WebMessagePort
import android.webkit.WebViewClient
import android.annotation.SuppressLint
import android.webkit.WebView

class WebsiteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wesite)

        // start of the activity
        val webView: WebView = findViewById(R.id.webView)
        webView.settings.javaScriptEnabled = true

        //optional zoom controls
        webView.settings.setSupportZoom(true)
        webView.settings.builtInZoomControls = true

        // handle navigation within the Webview
        webView.webViewClient = WebViewClient()

        // Display progress in the title bar
        webView.webChromeClient = WebChromeClient()

        // load a website
        val websiteUrl = "https://pillarmachine.com"
        webView.loadUrl(websiteUrl)
    }
}