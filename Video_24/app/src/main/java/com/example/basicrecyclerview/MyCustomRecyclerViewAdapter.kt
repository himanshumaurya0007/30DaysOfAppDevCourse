package com.example.basicrecyclerview

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyCustomRecyclerViewAdapter(
    private var newsArrayList: ArrayList<News>,
    var context: Activity
) : RecyclerView.Adapter<MyCustomRecyclerViewAdapter.MyCustomViewHolder>() {

    class MyCustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val sivNewsImage = itemView.findViewById<ShapeableImageView>(R.id.sivNewsImage)!!
        val tvNewsTitle = itemView.findViewById<TextView>(R.id.tvNewsTitle)!!
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyCustomRecyclerViewAdapter.MyCustomViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.cv_each_row, parent, false)
        return MyCustomViewHolder(itemView)
    }

    override fun onBindViewHolder(
        holder: MyCustomRecyclerViewAdapter.MyCustomViewHolder,
        position: Int
    ) {
        val currentItem = newsArrayList[position]
        holder.sivNewsImage.setImageResource(currentItem.newsImage)
        holder.tvNewsTitle.text = currentItem.newsHeading
    }

    override fun getItemCount(): Int {
        return newsArrayList.size
    }

}
