package com.example.myapplication

import android.content.Intent
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.myapplication.api.FlickrResponse
import com.example.myapplication.api.GalleryItem
import com.example.myapplication.api.PhotoResponse
import com.example.myapplication.databinding.ActivitySecondBinding
import com.example.myapplication.databinding.ListItemGalleryBinding
import kotlinx.coroutines.flow.Flow


class PhotoViewHolder(
     private val binding: ListItemGalleryBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(galleryItem: GalleryItem) {


        //For Flickr
//        binding.itemImageView.load(galleryItem.url)

        //For Pixabay
      binding.itemImageView.load(galleryItem.url)




        binding.root.setOnClickListener {


            val intent = Intent(binding.root.context, SecondActivity::class.java)
            intent.putExtra("url_s", galleryItem.url)
            intent.putExtra("title", galleryItem.title)

            binding.root.context.startActivity(intent)



//Toast for Flickr
            Toast.makeText(
                binding.root.context,
                "${galleryItem.title}",
                Toast.LENGTH_SHORT
            ).show()

//For Pixaaby
//            Toast.makeText(
//                binding.root.context,
//                "${galleryItem.tags}",
//                Toast.LENGTH_SHORT
//            ).show()
        }


    }
}
