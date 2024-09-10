package com.example.viewbinding_alertdialogue

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.viewbinding_alertdialogue.databinding.ActivityAlertDialogueBinding

class AlertDialogueActivity : AppCompatActivity() {

    private lateinit var viewBind: ActivityAlertDialogueBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBind = ActivityAlertDialogueBinding.inflate(layoutInflater)
        setContentView(viewBind.root)

        viewBind.btnBasicAlertDialog.setOnClickListener{
            val builder = AlertDialog.Builder(this)

            builder.setTitle("Are you sure?")
            builder.setMessage("Do you want to close the app?")

            builder.setIcon(R.drawable.baseline_exit_to_app_24)

                // What action should be performed when Yes is clicked ?
            builder.setPositiveButton("Yes", DialogInterface.OnClickListener { dialogInterface, i ->
                finish()
            })

                //  What action should be performed when Yes is clicked ?
            builder.setNegativeButton("No", DialogInterface.OnClickListener { dialogInterface, i ->
            })

            builder.show()
        }

        viewBind.btnSingleChoiceItemsAlertDialog.setOnClickListener{
            val options = arrayOf("Gulab Jamun", "Rasmallai", "Kaju Katli")

            val builder = AlertDialog.Builder(this)
            builder.setTitle("What's your favourite sweet?")

                // what action should be performed when user clicks on any option
            builder.setSingleChoiceItems(options, 0, DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(this, "You clicked on ${options[which]}", Toast.LENGTH_SHORT).show()
            })

                // What action should be performed when Yes is clicked ?
            builder.setPositiveButton("Submit", DialogInterface.OnClickListener { dialogInterface, i ->
            })

                //  What action should be performed when No is clicked ?
            builder.setNegativeButton("Decline", DialogInterface.OnClickListener { dialogInterface, i ->
            })

            builder.show()
        }

        viewBind.btnMultiChoiceItemsAlertDialog.setOnClickListener{
            val options = arrayOf("Gulab Jamun", "Rasmallai", "Kaju Katli")

            val builder = AlertDialog.Builder(this)
            builder.setTitle("What's your favourite sweet?")

            builder.setMultiChoiceItems(options, null, DialogInterface.OnMultiChoiceClickListener { dialog, which, isChecked ->
                Toast.makeText(this, "You clicked on ${options[which]}", Toast.LENGTH_SHORT).show()
            })

                // What action should be performed when Yes is clicked ?
            builder.setPositiveButton("Submit", DialogInterface.OnClickListener { dialogInterface, i ->
            })

                //  What action should be performed when No is clicked ?
            builder.setNegativeButton("Decline", DialogInterface.OnClickListener { dialogInterface, i ->
            })

            builder.show()
        }
    }
}