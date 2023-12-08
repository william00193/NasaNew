package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)




//What my second activity is getting and displaying
//Step 1: Finding my previously saved data
        val image_url = intent.getStringExtra("hdurl")

//Step 2: Finding my imageView and setting the image_url to it
        val imageView = findViewById<ImageView>(R.id.imageViewNew)

//This function was something new that Android Studio Bot Suggested
//This required a new dependency and an annotationProcessor in the gradle file
//Step 3: Using Glide to load the image_url into the imageView
        Glide.with(this).load(image_url).into(imageView)




//Step 1: Finding my previously saved data
        val title = intent.getStringExtra("title")

//Step 2: Finding my textView and setting the title to it
        val textView = findViewById<TextView>(R.id.textViewNew)

//Step 3: Setting the title to the textView
        textView.text = title
    }
}