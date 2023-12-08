package com.example.myapplication

import android.content.Intent
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.myapplication.api.GalleryItem
import com.example.myapplication.databinding.ListItemGalleryBinding



class PhotoViewHolder(
     private val binding: ListItemGalleryBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(galleryItem: GalleryItem) {



//Loading the initial url's from Flickr into my recycler view
      binding.itemImageView.load(galleryItem.url)



//My Onclick Listener that is going to send the data to the next activity
        binding.root.setOnClickListener {


//What onCLick is going to save and send to the next activity
            val intent = Intent(binding.root.context, SecondActivity::class.java)

            intent.putExtra("hdurl", galleryItem.url)

            intent.putExtra("title", galleryItem.title)

            binding.root.context.startActivity(intent)


        }


    }
}
