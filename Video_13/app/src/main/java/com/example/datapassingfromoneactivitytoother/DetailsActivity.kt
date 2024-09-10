package com.example.datapassingfromoneactivitytoother

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val tvDetails = findViewById<TextView>(R.id.tvDetails)

        // Retrieve the passed data using the key from MainActivity
        val detailsOfTheStudent = intent.getStringExtra(MainActivity.KEY)

        // Find the TextView and display the submitted details
        tvDetails.text = "$detailsOfTheStudent"
    }
}