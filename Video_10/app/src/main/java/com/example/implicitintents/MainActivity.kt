package com.example.implicitintents

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cvCamera = findViewById<CardView>(R.id.cvCamera)
        val cvWebsite = findViewById<CardView>(R.id.cvWebsite)

        cvCamera.setOnClickListener{
            val openCamera = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(openCamera)
        }

        cvWebsite.setOnClickListener{
        val openWebsite = Intent(Intent.ACTION_VIEW)
            openWebsite.data = Uri.parse("https://www.wikipedia.org/")
            startActivity(openWebsite)
        }


    }
}