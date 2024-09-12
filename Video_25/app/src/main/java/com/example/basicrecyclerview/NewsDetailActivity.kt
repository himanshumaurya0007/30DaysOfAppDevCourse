package com.example.basicrecyclerview

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class NewsDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)

        // Initialize views for displaying news details
        val newsHeadingImgView = findViewById<ImageView>(R.id.ivNewsImage)
        val newsHeadingTxtView = findViewById<TextView>(R.id.tvNewsHeading)
        val newsContentTxtView = findViewById<TextView>(R.id.tvNewsContent)

        // Get data passed from MainActivity
        val heading = intent.getStringExtra("heading")
        val imageId = intent.getIntExtra("imageId", R.drawable.img1)
        val newsContent = intent.getStringExtra("newsContent")

        // Set data to views
        newsHeadingTxtView.text = heading
        newsContentTxtView.text = newsContent
        newsHeadingImgView.setImageResource(imageId)
    }
}