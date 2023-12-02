package com.example.myapplication.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

//@JsonClass(generateAdapter = true)
//data class PhotoResponse(
//     @Json (name = "id") val galleryItem: List<GalleryItem>
//)

//creating a data class for my PhotoResponse
//expecting binder but got null!

//@JsonClass(generateAdapter = true)
//data class PhotoResponse(
//     @Json(name = "photo") val galleryItems: List<GalleryItem>
//)

@JsonClass(generateAdapter = true)
data class PhotoResponse(
     @Json(name = "photo") val galleryItems: List<GalleryItem>
)
