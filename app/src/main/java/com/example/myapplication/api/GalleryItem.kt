package com.example.myapplication.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass



//Flickr GalleryItem
@JsonClass(generateAdapter = true)
data class GalleryItem(
    val title: String,
    val id: String,
    @Json(name = "url_s") val url: String,
)

//A resource is failing to call close when application is launched



//Pixabay GalleryItem, rewrite this code section to bring back necessary pixabay fields
//Call this data class GalleryItem


//@JsonClass(generateAdapter = true)
//data class GalleryItem(
//    val id: Int,
//    val total: Int,
//    val tags: String,
//    val pageURL: String,
//    val previewURL: String,
//    @Json(name = "webformatURL") val url : String,
//)


//Everything that pixabay brings back
//"id": 1236875,
//"pageURL": "https://pixabay.com/photos/animal-panda-mammal-species-fauna-1236875/",
//"type": "photo",
//"tags": "animal, panda, mammal",
//"previewURL": "https://cdn.pixabay.com/photo/2016/03/04/22/54/animal-1236875_150.jpg",
//"previewWidth": 150,
//"previewHeight": 99,
//"webformatURL": "https://pixabay.com/get/gc33231df327522365b1191fc08d74bafc0979676c7082659bf669a902494e74ac7cdfec1b879b67f5e1c89a35533ea12a6367aa0be3f7fc792b98f484d35f9e6_640.jpg",
//"webformatWidth": 640,
//"webformatHeight": 426,
//"largeImageURL": "https://pixabay.com/get/gbf733f1079c22701ffcfb90569c099a875da826b01cd556c0451a26bccde95d96348a4f3e2645f7915a404de7999219121c548445dcf3ff62ad4102deea7ae2d_1280.jpg",
//"imageWidth": 3456,
//"imageHeight": 2304,
//"imageSize": 1684392,
//"views": 208359,
//"downloads": 127177,
//"collections": 419,
//"likes": 483,
//"comments": 75,
//"user_id": 2163857,
//"user": "Cimberley",
//"userImageURL": "https://cdn.pixabay.com/user/2016/03/04/23-10-07-96_250x250.jpg"