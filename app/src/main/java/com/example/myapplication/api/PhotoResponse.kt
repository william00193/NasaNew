package com.example.myapplication.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


//Data class that is defining the 'GalleryItem'

@JsonClass(generateAdapter = true)
data class PhotoResponse(
    val galleryItems: List<GalleryItem>
)



//What is defining the galleryitem from pixabay
//"total": 852,
//"totalHits": 500,
//"hits": [