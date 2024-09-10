package com.example.intents

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnHome = findViewById<Button>(R.id.btnHome)

        btnHome.setOnClickListener {
            val moveToHomeActivity = Intent(applicationContext, HomeActivity::class.java)
            startActivity(moveToHomeActivity)

        }
    }
}