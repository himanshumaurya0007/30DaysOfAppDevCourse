package com.example.basicrecyclerview

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    // RecyclerView for displaying news. rvNews => RecyclerViewNews
    private lateinit var rvNews : RecyclerView

    // ArrayList to hold news data. alNews => ArrayListNews
    private lateinit var alNews : ArrayList<News>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the RecyclerView
        rvNews = findViewById(R.id.rvNewsTemplate)

        // Array of images for the news items. iaNews => ImageArrayNews
        val iaNews = arrayOf(
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6
        )

        // Array of titles for the news items. taNews => TitleArrayNews
        val taNews = arrayOf(
            "U.K. Foreign Secretary James Cleverly raises issue of BBC tax searches with EAM Jaishankar",
            "Cooking gas prices hiked by ₹50 for domestic, ₹350.50 for commercial cylinders",
            "Joe Biden appoints two prominent Indian-American corporate leaders to his Export Council",
            "Sergey Lavrov will raise suspected bombing of Nord Stream II at G20: Russian Foreign Ministry",
            "Belarusian leader Lukashenko visits China amid Ukraine tensions",
            "China rips new U.S. House committee on countering Beijing",
            "Largest gathering of Foreign Ministers hosted by any G20 presidency: Foreign Secretary Vinay Kwatra"
        )

        // Array of content for the news items
        val contentsOfNews = arrayOf(
            getString(R.string.news_content1), getString(R.string.news_content2),
            getString(R.string.news_content3), getString(R.string.news_content4),
            getString(R.string.news_content5), getString(R.string.news_content6)
        )

        // Set layout manager for RecyclerView (vertical list)
        rvNews.layoutManager = LinearLayoutManager(this)

        // Initialize the ArrayList
        alNews = arrayListOf<News>()

        // Populate the ArrayList with News objects
        for(currentIndex in iaNews.indices){
            val news = News(taNews[currentIndex], iaNews[currentIndex], contentsOfNews[currentIndex])
            alNews.add(news)
        }

        // Set up the custom RecyclerView adapter
        val myCustomRVAdapter = MyCustomRecyclerViewAdapter(alNews, this)
        rvNews.adapter = myCustomRVAdapter

        // Set up a click listener for each item in the RecyclerView
        myCustomRVAdapter.customSetOnItemClickListener(object : MyCustomRecyclerViewAdapter.customOnItemClickListener {

            override fun customOnItemClick(position: Int) {

                // Handle item click - start NewsDetailActivity with the clicked news item details
                val intent = Intent(this@MainActivity, NewsDetailActivity::class.java)
                intent.putExtra("heading", alNews[position].newsHeading)
                intent.putExtra("imageId", alNews[position].newsImage)
                intent.putExtra("newsContent", alNews[position].newsContent)
                startActivity(intent)
            }
        })
    }
}