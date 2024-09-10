// ******************************* View Binding *******************************

package com.example.viewbinding_alertdialogue

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.viewbinding_alertdialogue.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewBind: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBind.root)

        viewBind.button.setOnClickListener {
            if (viewBind.checkBox.isChecked) {

                // Open a New Screen

                val moveToAlertDialogueActivity =
                    Intent(applicationContext, AlertDialogueActivity::class.java)
                startActivity(moveToAlertDialogueActivity)
            } else {
                viewBind.checkBox.buttonTintList = ColorStateList.valueOf(Color.RED)
                Toast.makeText(this, "Please accept the T&C.", Toast.LENGTH_SHORT).show()
            }

        }
    }
}