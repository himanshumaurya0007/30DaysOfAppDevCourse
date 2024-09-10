package com.example.webview

import android.os.Build
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webView = findViewById<WebView>(R.id.webView)
        webViewFunction(webView)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun webViewFunction(webViewFunVar: WebView?) {
        webViewFunVar?.webViewClient = WebViewClient()

        webViewFunVar?.apply {
            settings.javaScriptEnabled = true
            // Check if the current Android version is Oreo or higher before setting safe browsing
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                settings.safeBrowsingEnabled = true
            }
            loadUrl("https://www.wikipedia.org")
        }
    }
}