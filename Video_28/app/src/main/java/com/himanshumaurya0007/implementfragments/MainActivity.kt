package com.himanshumaurya0007.implementfragments

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.himanshumaurya0007.implementfragments.ui.login.LoginFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnClock = findViewById<Button>(R.id.btnClock)
        val btnImage = findViewById<Button>(R.id.btnImage)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnClock.setOnClickListener{
         replaceFrameLayoutWithFragment(ClockFragment())
        }
        btnImage.setOnClickListener{
         replaceFrameLayoutWithFragment(ImageFragment())
        }
        btnLogin.setOnClickListener{
         replaceFrameLayoutWithFragment(LoginFragment())
        }

    }

    private fun replaceFrameLayoutWithFragment(fragment : Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }
}