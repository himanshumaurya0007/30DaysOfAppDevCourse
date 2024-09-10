// ******************************* TodoList App *******************************
package com.example.basiclistview_video22

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lvTodoList = findViewById<ListView>(R.id.lvTodoList)

        // Creating array of the list and adding items to it.
        val elementOfTodoTask = arrayListOf<String>()
        elementOfTodoTask.add("Visit CP Hanuman Mandir")
        elementOfTodoTask.add("Attend Exam")
        elementOfTodoTask.add("Complete the App Dev Project")
        elementOfTodoTask.add("Buy bhindi from market")
        elementOfTodoTask.add("Work on resume")
        elementOfTodoTask.add("Improve internet presence")

        // Use ArrayAdapter() for list
        // Using in-built layout simple_list_item_1
        val adapterOfTodoList =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, elementOfTodoTask)
        lvTodoList.adapter = adapterOfTodoList

        lvTodoList.setOnItemClickListener { parent, view, position, id ->
            val text = "Clicked on item: " + (view as TextView).text.toString()
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }
    }
}