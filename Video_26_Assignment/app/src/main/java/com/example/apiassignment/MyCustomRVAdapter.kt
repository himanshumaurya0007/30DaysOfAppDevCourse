package com.example.apiassignment

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class MyCustomRVAdapter(val context: Activity, val productArrayList: List<Product>) :
    RecyclerView.Adapter<MyCustomRVAdapter.MyCustomViewHolder>() {

    class MyCustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView
        var image: ShapeableImageView
        var price: TextView
        var brand: TextView
        var rating: TextView
        var ratingBar: RatingBar

        init {
            title = itemView.findViewById(R.id.productTitle)
            image = itemView.findViewById(R.id.productImage)
            price = itemView.findViewById(R.id.productPrice)
            brand = itemView.findViewById(R.id.productBrand)
            rating = itemView.findViewById(R.id.productRating)
            ratingBar = itemView.findViewById(R.id.productRatingBar)
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
        holder.price.text = "Price: $${currentItem.price}"
        holder.brand.text = "Brand: ${currentItem.brand}"
        holder.rating.text = "Rating: ${currentItem.rating}"

        // Set rating to RatingBar
        holder.ratingBar.rating = currentItem.rating.toFloat()

        // Load thumbnail image using Picasso
        Picasso.get().load(currentItem.thumbnail).into(holder.image)
    }

    override fun getItemCount(): Int {
        return productArrayList.size
    }
}
