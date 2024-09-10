package com.example.intents

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val btnMain = findViewById<Button>(R.id.btnMain)

        btnMain.setOnClickListener {
            val moveToMainActivity = Intent(applicationContext, MainActivity::class.java)
            startActivity(moveToMainActivity)
        }
    }
}