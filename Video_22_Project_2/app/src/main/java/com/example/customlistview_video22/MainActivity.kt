package com.example.customlistview_video22

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Declaration
    private lateinit var userArrayList : ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = arrayOf("Himanshu", "Avinash", "Niraj", "Suhana", "Sadhana")
        val lastMsg = arrayOf("Hey! I'm pretty fine.", "I am fine", "Good", "Awesome", "cool")
        val lastMsgTime = arrayOf("6:25 AM", "7:30 PM", "5:00 PM", "6:25 AM", "7:30 PM")
        val phoneNumber = arrayOf("1234567890", "9087654321", "6543980721", "7065439821", "4159251517")
        val imgId = intArrayOf(R.drawable.pic5, R.drawable.pic1, R.drawable.pic2,
            R.drawable.pic3, R.drawable.pic4)

        // Initialization
        userArrayList = ArrayList()

        // To iterate with indexes (indices) of each item of arrays
        for(eachIndex in name.indices){
            val user = User(name[eachIndex], lastMsg[eachIndex], lastMsgTime[eachIndex], phoneNumber[eachIndex],
                imgId[eachIndex])

            userArrayList.add(user)
        }

        val lvNotificationMessage = findViewById<ListView>(R.id.lvNotificationMessage)
        lvNotificationMessage.isClickable = true // By default it's true but still we are setting it as true

        // Creating Custom Adapter { MyAdapter() }
        lvNotificationMessage.adapter = MyAdapter(this, userArrayList)

        lvNotificationMessage.setOnItemClickListener { parent, view, position, id ->
            // open a new activity
            val userName = name[position]
            val userPhone = phoneNumber[position]
            val imageId = imgId[position]

            val moveToUserActivity = Intent(this, UserActivity::class.java)

            moveToUserActivity.putExtra("name", userName)
            moveToUserActivity.putExtra("phone", userPhone)
            moveToUserActivity.putExtra("imageId", imageId)
            startActivity(moveToUserActivity)
        }
    }
}