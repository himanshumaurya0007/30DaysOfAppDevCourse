package com.example.basicrecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvNews : RecyclerView // rvNews => RecyclerViewNews
    private lateinit var alNews : ArrayList<News> // alNews => ArrayListNews

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvNews = findViewById(R.id.rvNewsTemplate)

        var iaNews = arrayOf( // iaNews => ImageArrayNews
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6
        )

        var taNews = arrayOf( // taNews => TitleArrayNews
            "U.K. Foreign Secretary James Cleverly raises issue of BBC tax searches with EAM Jaishankar",
            "Cooking gas prices hiked by ₹50 for domestic, ₹350.50 for commercial cylinders",
            "Joe Biden appoints two prominent Indian-American corporate leaders to his Export Council",
            "Sergey Lavrov will raise suspected bombing of Nord Stream II at G20: Russian Foreign Ministry",
            "Belarusian leader Lukashenko visits China amid Ukraine tensions",
            "China rips new U.S. House committee on countering Beijing",
            "Largest gathering of Foreign Ministers hosted by any G20 presidency: Foreign Secretary Vinay Kwatra"
        )
        
        // to set hav-bhav of items inside recyclerview, vertically scrolling, horizontally, uniform grid
        rvNews.layoutManager = LinearLayoutManager(this)
        alNews = arrayListOf<News>()

        for(currentIndex in iaNews.indices){
            val news = News(taNews[currentIndex], iaNews[currentIndex])
            alNews.add(news)
        }

        var myCustomRVAdapter = MyCustomRecyclerViewAdapter(alNews, this)
        rvNews.adapter = myCustomRVAdapter
    }
}