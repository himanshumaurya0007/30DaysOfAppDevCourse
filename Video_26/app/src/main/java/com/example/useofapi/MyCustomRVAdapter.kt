package com.example.useofapi

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class MyCustomRVAdapter(val context: Activity, val productArrayList: List<Product>) :
    RecyclerView.Adapter<MyCustomRVAdapter.MyCustomViewHolder>() {

        class MyCustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView
        var image: ShapeableImageView

        init {
            title = itemView.findViewById(R.id.productTitle)
            image = itemView.findViewById(R.id.productImage)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyCustomRVAdapter.MyCustomViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.each_item, parent, false)
        return MyCustomViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyCustomRVAdapter.MyCustomViewHolder, position: Int) {
        val currentItem = productArrayList[position]

        // Set product data in TextViews
        holder.title.text = currentItem.title

        // image view, how to show image in image view if the image is in form of url. 3rd Party Library (Picasso)
        Picasso.get().load(currentItem.thumbnail).into(holder.image);
    }

    override fun getItemCount(): Int {
        return productArrayList.size
    }
}