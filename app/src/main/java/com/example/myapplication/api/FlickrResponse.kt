package com.example.myapplication.api


import com.squareup.moshi.JsonClass


//What is defining the entire response from Flickr
@JsonClass(generateAdapter = true)
data class FlickrResponse(

   val photos: PhotoResponse

)