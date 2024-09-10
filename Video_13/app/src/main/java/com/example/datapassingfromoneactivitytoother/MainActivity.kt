package com.example.datapassingfromoneactivitytoother

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Creating a key for passing data
    companion object {
        const val KEY = "com.example.datapassingfromoneactivitytoother.MainActivity.KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etFirstName = findViewById<EditText>(R.id.etFirstName)
        val etLastName = findViewById<EditText>(R.id.etLastName)
        val etEmailAddress = findViewById<EditText>(R.id.etEmailAddress)
        val etPhone = findViewById<EditText>(R.id.etPhone)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)

        btnSubmit.setOnClickListener {

            val submittedDetails =
                "First Name: " + etFirstName.text.toString() + "\n" + "Last Name: " + etLastName.text.toString() + "\n" +
                        "Email Address: " + etEmailAddress.text.toString() + "\n" + "Phone Number: " + etPhone.text.toString()

            val navigateToDetailsActivity = Intent(this, DetailsActivity::class.java)
            navigateToDetailsActivity.putExtra(KEY, submittedDetails)
            startActivity(navigateToDetailsActivity)

        }
    }
}