package com.example.alertdialogueassignment_video19

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.alertdialogueassignment_video19.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewBind: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBind.root)

        viewBind.tvQues1.setOnClickListener {
            val options = arrayOf(
                "A) MainActivity",
                "B) Application",
                "C) AndroidManifest.xml",
                "D) Fragment"
            )

            val builder = AlertDialog.Builder(this)
            builder.setTitle("Which of the following is the entry point for an Android app in Kotlin?")

            builder.setSingleChoiceItems(
                options,
                0,
                null
            )

            // What action should be performed when Yes is clicked ?
            builder.setPositiveButton(
                "Submit",
                DialogInterface.OnClickListener { dialogInterface, i ->
                    Toast.makeText(this, "Correct Answer: A) MainActivity", Toast.LENGTH_SHORT)
                        .show()

                })

            builder.show()
        }

        viewBind.tvQues2.setOnClickListener {
            val options = arrayOf(
                "A) ConstraintLayout",
                "B) RecyclerView",
                "C) Retrofit",
                "D) TextView"
            )

            val builder = AlertDialog.Builder(this)
            builder.setTitle("Which of the following components can be used to build the UI in an Android app using Kotlin?")

            builder.setMultiChoiceItems(options, null, null)

            // What action should be performed when Yes is clicked ?
            builder.setPositiveButton(
                "Submit",
                DialogInterface.OnClickListener { dialogInterface, i ->
                    Toast.makeText(
                        this,
                        "Correct Answers: A) ConstraintLayout, B) RecyclerView, D) TextView",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                })

            builder.show()
        }

        viewBind.tvQues3.setOnClickListener {
            val options = arrayOf(
                "A) startActivity()",
                "B) launchActivity()",
                "C) openActivity()",
                "D) runActivity()"
            )

            val builder = AlertDialog.Builder(this)
            builder.setTitle("Which function is used to start an activity in Kotlin?")

            // what action should be performed when user clicks on any option
            builder.setSingleChoiceItems(options, 0, null)

            // What action should be performed when Yes is clicked ?
            builder.setPositiveButton(
                "Submit",
                DialogInterface.OnClickListener { dialogInterface, i ->
                    Toast.makeText(this, "Correct Answer: A) startActivity()", Toast.LENGTH_SHORT)
                        .show()
                })

            builder.show()
        }

        viewBind.tvQues4.setOnClickListener {
            val options = arrayOf(
                "A) onCreate()",
                "B) onDestroy()",
                "C) onPause()",
                "D) onClick()"
            )

            val builder = AlertDialog.Builder(this)
            builder.setTitle("Which of the following are lifecycle methods in an Android activity?")

            builder.setMultiChoiceItems(options, null, null)

            // What action should be performed when Yes is clicked ?
            builder.setPositiveButton(
                "Submit",
                DialogInterface.OnClickListener { dialogInterface, i ->
                    Toast.makeText(
                        this,
                        "Correct Answers: A) onCreate(), B) onDestroy(), C) onPause()",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                })

            builder.show()
        }

        viewBind.tvQues5.setOnClickListener {

            val options = arrayOf(
                "A) const val PI = 3.14",
                "B) final val PI = 3.14",
                "C) static val PI = 3.14",
                "D) var PI = 3.14"
            )

            val builder = AlertDialog.Builder(this)
            builder.setTitle("Which of the following is the correct way to declare a constant in Kotlin?")

            builder.setSingleChoiceItems(
                options,
                0,
                null
            )

            // What action should be performed when Yes is clicked ?
            builder.setPositiveButton(
                "Submit",
                DialogInterface.OnClickListener { dialogInterface, i ->
                    Toast.makeText(
                        this,
                        "Correct Answer: A) const val PI = 3.14",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                })

            builder.show()
        }

        viewBind.tvQues6.setOnClickListener {
            val options = arrayOf(
                "A) SQLiteHelper",
                "B) SQLiteDatabase",
                "C) DatabaseHelper",
                "D) SQLiteOpenHelper"
            )

            val builder = AlertDialog.Builder(this)
            builder.setTitle("Which class in Android is used for database operations with SQLite?")

            builder.setSingleChoiceItems(
                options,
                0,
                null
            )

            // What action should be performed when Yes is clicked ?
            builder.setPositiveButton(
                "Submit",
                DialogInterface.OnClickListener { dialogInterface, i ->
                    Toast.makeText(this, "Correct Answer: D) SQLiteOpenHelper", Toast.LENGTH_SHORT)
                        .show()
                })

            builder.show()
        }

        viewBind.tvQues7.setOnClickListener {
            val options = arrayOf(
                "A) let",
                "B) apply",
                "C) init",
                "D) also"
            )

            val builder = AlertDialog.Builder(this)
            builder.setTitle("Which of the following are Kotlin scope functions?")

            builder.setMultiChoiceItems(options, null, null)

            // What action should be performed when Yes is clicked ?
            builder.setPositiveButton(
                "Submit",
                DialogInterface.OnClickListener { dialogInterface, i ->
                    Toast.makeText(
                        this,
                        "Correct Answers: A) let, B) apply, D) also",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                })

            builder.show()
        }

        viewBind.btnExit.setOnClickListener {
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
    }
}