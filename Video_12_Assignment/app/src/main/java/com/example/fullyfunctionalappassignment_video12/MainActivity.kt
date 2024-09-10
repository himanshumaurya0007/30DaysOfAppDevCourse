package com.example.fullyfunctionalappassignment_video12

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLetsGo = findViewById<Button>(R.id.btnLetsGo)

        btnLetsGo.setOnClickListener {
            val moveToKbActivity = Intent(applicationContext, KnowledgeBaseActivity::class.java)
            startActivity(moveToKbActivity)
        }
    }
}