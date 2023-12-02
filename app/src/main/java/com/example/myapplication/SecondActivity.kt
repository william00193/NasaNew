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



        val image_url = intent.getStringExtra("url_s")
        val imageView = findViewById<ImageView>(R.id.imageViewNew)
        Glide.with(this).load(image_url).into(imageView)

        val title = intent.getStringExtra("title")
        val textView = findViewById<TextView>(R.id.textViewNew)
        textView.text = title
    }
}