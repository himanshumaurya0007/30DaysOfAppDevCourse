package com.example.dynamic_photo_frame_app

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

import com.example.dynamic_photo_frame_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewBind : ActivityMainBinding

    private var currentImage = 0
    private lateinit var imgViews: Array<ImageView>
    private var imgNames = arrayOf(
        "MS Dhoni",
        "Dhoni behind Stumps",
        "Wicketkeeping kit and bat of MS Dhoni at Blades of Glory Cricket Museum, Pune",
        "Mahendra Singh Dhoni batting",
        "MS Dhoni in 2011",
        "The Chief of Army Staff, Gen. V.K. Singh pipping in the Rank of Hon. Lt. Col. to Indian Skipper M.S. Dhoni, in New Delhi on November 01, 2011",
        "MS Dhoni's jersey at Blades of Glory Cricket Museum, Pune",
        "MS Dhoni",
        "The President, Shri Ram Nath Govind presenting the Padma Bhushan Award to Shri M.S. Dhoni, at the Civil Investiture Ceremony-II, at Rashtrapati Bhavan, in New Delhi on April 02, 2018"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBind.root)

        val tvImgViewName = findViewById<TextView>(R.id.tvImgViewName)

        // Initialize ImageView array with correct IDs
        imgViews = arrayOf(
            findViewById(R.id.pics0),
            findViewById(R.id.pics1),
            findViewById(R.id.pics2),
            findViewById(R.id.pics3),
            findViewById(R.id.pics4),
            findViewById(R.id.pics5),
            findViewById(R.id.pics6),
            findViewById(R.id.pics7),
            findViewById(R.id.pics8)
        )

        // Set the initial image
        imgViews[currentImage].alpha = 1f
        tvImgViewName.text = imgNames[currentImage]

        viewBind.imgBtnPrevious.setOnClickListener {
            val currentImageIdOfTypeString = "pics$currentImage"
            val currentImageIdOfTypeInt = resources.getIdentifier(currentImageIdOfTypeString, "id", packageName)
            val currentImageView = findViewById<ImageView>(currentImageIdOfTypeInt)
            currentImageView.alpha = 0f

            // Update the currentImage index
            currentImage = (imgViews.size + currentImage - 1) % imgViews.size

            val idOfImageToBeShownOfTypeString = "pics$currentImage"
            val idOfImageToBeShownOfTypeInt = resources.getIdentifier(idOfImageToBeShownOfTypeString, "id", packageName)
            val newImageView = findViewById<ImageView>(idOfImageToBeShownOfTypeInt)
            newImageView.alpha = 1f

            tvImgViewName.text = imgNames[currentImage]
        }

        viewBind.imgBtnNext.setOnClickListener {
            val currentImageIdOfTypeString = "pics$currentImage"
            val currentImageIdOfTypeInt = resources.getIdentifier(currentImageIdOfTypeString, "id", packageName)
            val currentImageView = findViewById<ImageView>(currentImageIdOfTypeInt)
            currentImageView.alpha = 0f

            // Update the currentImage index
            currentImage = (imgViews.size + currentImage + 1) % imgViews.size

            val idOfImageToBeShownOfTypeString = "pics$currentImage"
            val idOfImageToBeShownOfTypeInt = resources.getIdentifier(idOfImageToBeShownOfTypeString, "id", packageName)
            val newImageView = findViewById<ImageView>(idOfImageToBeShownOfTypeInt)
            newImageView.alpha = 1f

            tvImgViewName.text = imgNames[currentImage]
        }

    }
}