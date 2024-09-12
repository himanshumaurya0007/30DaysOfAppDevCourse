package com.example.basicrecyclerview

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyCustomRecyclerViewAdapter(
    private var newsArrayList: ArrayList<News>, // List of news items
    var context: Activity // Context from the calling activity
) : RecyclerView.Adapter<MyCustomRecyclerViewAdapter.MyCustomViewHolder>() {

    // Step 1: Create an interface with a function for click events
    interface customOnItemClickListener {
        fun customOnItemClick(position: Int)
    }

    // Step 2: Lateinit the created interface
    private lateinit var myCustomListener: customOnItemClickListener

    // Step 3: Create a function to initialize the click listener
    fun customSetOnItemClickListener(listener: customOnItemClickListener) {
        myCustomListener = listener
    }

    // ViewHolder class to hold item views
    // Step 4: Include the interface as a variable as a parameter
    class MyCustomViewHolder(itemView: View, listener: customOnItemClickListener) :
        RecyclerView.ViewHolder(itemView) {
        val sivNewsImage = itemView.findViewById<ShapeableImageView>(R.id.sivNewsImage)!!
        val tvNewsTitle = itemView.findViewById<TextView>(R.id.tvNewsTitle)!!

        // Step 5: Initialize with click listener
        init {
            itemView.setOnClickListener { // Built-in setOnClickListener
                listener.customOnItemClick(adapterPosition)
            }
        }
    }

    // Create a new ViewHolder for each item
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyCustomRecyclerViewAdapter.MyCustomViewHolder {

        // Inflate the layout for each item
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.cv_each_row, parent, false)
        return MyCustomViewHolder(itemView, myCustomListener)
    }

    // Bind data to each ViewHolder
    override fun onBindViewHolder(
        holder: MyCustomRecyclerViewAdapter.MyCustomViewHolder,
        position: Int
    ) {
        val currentItem = newsArrayList[position]
        holder.sivNewsImage.setImageResource(currentItem.newsImage)  // Set image resource
        holder.tvNewsTitle.text = currentItem.newsHeading // Set news title
    }

    // Return the total number of items
    override fun getItemCount(): Int {
        return newsArrayList.size
    }

}
