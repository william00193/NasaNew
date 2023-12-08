package com.example.myapplication.api


import retrofit2.http.GET

private const val API_KEY = "a5Qn5reNAPxJFWmzLCJ5S3RlvkUvqcl0qdg8mvgI"

interface FlickrAPI {


    //For NASA
    @GET(
        "apod" +
                "?api_key=$API_KEY" +
                "&count=100"
    )


    suspend fun fetchPhotos(): List<GalleryItem>

}

//https://pixabay.com/api/?key=40895557-d49a07cca955c5315c2bae711&q=bear&format=json&nojsoncallback=1

