package com.example.customlistview_video22

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import de.hdodenhof.circleimageview.CircleImageView

class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        val name = intent.getStringExtra("name")
        val phoneNumber = intent.getStringExtra("phone")
        val imageId = intent.getIntExtra("imageId", R.drawable.pic5)

        val tvName = findViewById<TextView>(R.id.tVName)
        val tvPhoneNumber = findViewById<TextView>(R.id.tVPhoneNumber)
        val civProfileImage = findViewById<CircleImageView>(R.id.civProfileImage)

        tvName.text = name
        tvPhoneNumber.text = phoneNumber
        civProfileImage.setImageResource(imageId)
    }
}