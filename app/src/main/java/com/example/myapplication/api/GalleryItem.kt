package com.example.myapplication.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass



//Data class that is defining the attributes in my PhotoResponse
@JsonClass(generateAdapter = true)
data class GalleryItem(
    val copyright: String,
    val date: String,
    val explanation: String,
    @Json(name = "hdurl") val url: String,
    val media_type: String,
    val service_version: String,
    val title: String,
    @Json(name = "url") val url2: String,
)




