package com.example.fullyfunctionalappassignment_video12

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView


class KnowledgeBaseActivity : AppCompatActivity() {
    @SuppressLint("QueryPermissionsNeeded")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_knowledge_base)

        val cvProgramLang = findViewById<CardView>(R.id.cvProgramLang)
        val cvAndroidAppDev = findViewById<CardView>(R.id.cvAndroidAppDev)
        val cvWebDev = findViewById<CardView>(R.id.cvWebDev)
        val cvVcs = findViewById<CardView>(R.id.cvVcs)
        val cvAi = findViewById<CardView>(R.id.cvAi)
        val cvMl = findViewById<CardView>(R.id.cvMl)
        val cvDb = findViewById<CardView>(R.id.cvDb)
        val btnEmail = findViewById<Button>(R.id.btnEmail)
        val btnPhoneCall = findViewById<Button>(R.id.btnPhoneCall)

//        Explicit Intents
        cvProgramLang.setOnClickListener {
            val moveToProgramLangActivity =
                Intent(applicationContext, ProgrammingLanguagesActivity::class.java)
            startActivity(moveToProgramLangActivity)
        }

        cvAndroidAppDev.setOnClickListener {
            val moveToAndAppDevActivity =
                Intent(applicationContext, AndroidAppDevelopmentActivity::class.java)
            startActivity(moveToAndAppDevActivity)
        }

        cvWebDev.setOnClickListener {
            val moveToWebDevActivity =
                Intent(applicationContext, WebDevelopmentActivity::class.java)
            startActivity(moveToWebDevActivity)
        }

        cvVcs.setOnClickListener {
            val moveToVersionControlSystemActivity =
                Intent(applicationContext, VersionControlSystemActivity::class.java)
            startActivity(moveToVersionControlSystemActivity)
        }

        cvAi.setOnClickListener {
            val moveToAiActivity =
                Intent(applicationContext, ArtificialIntelligenceActivity::class.java)
            startActivity(moveToAiActivity)
        }

        cvMl.setOnClickListener {
            val moveToMlActivity = Intent(applicationContext, MachineLearningActivity::class.java)
            startActivity(moveToMlActivity)
        }

        cvDb.setOnClickListener {
            val moveToDbActivity = Intent(applicationContext, DatabaseActivity::class.java)
            startActivity(moveToDbActivity)
        }

//        Implicit Intents
        btnEmail.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:") // Only email apps should handle this
                putExtra(Intent.EXTRA_EMAIL, arrayOf("abc@gmail.com")) // Optional: Set a default email
                putExtra(Intent.EXTRA_SUBJECT, "Opportunity to Join Our Team")
                putExtra(Intent.EXTRA_TEXT, "Respected ABC,\n\nWe were impressed with your application and would like to discuss the opportunity to join our team further. Please let us know your availability for a follow-up conversation.\n\nBest regards,\n[Hiring Manager's Name]\n[Company Name]")
            }
            if (emailIntent.resolveActivity(packageManager) != null) {
                startActivity(emailIntent)
            }
        }

        btnPhoneCall.setOnClickListener {
            val phoneIntent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:+91 1234567890") // Replace with the phone number
            }
            if (phoneIntent.resolveActivity(packageManager) != null) {
                startActivity(phoneIntent)
            }
        }

    }
}