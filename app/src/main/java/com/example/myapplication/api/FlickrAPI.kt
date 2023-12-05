package com.example.myapplication.api


import retrofit2.http.GET

private const val API_KEY = "38966820aba3820d74f6b3121335fe3d"

interface FlickrAPI {

    @GET(
        "services/rest/?method=flickr.interestingness.getList" +
                "&api_key=$API_KEY" +
                "&format=json" +
                "&page=4"+
                "&per_page=100"+
                "&nojsoncallback=1" +
                "&extras=url_s"
    )

//    @GET("api/?key=40895557-d49a07cca955c5315c2bae711" +
//            "&q=panda" +
//            "&format=json" +
//            "&page=4"+
//            "&per_page=100"+
//            "&nojsoncallback=1"
//    )



// suspend fun fetchContents(): String
//    suspend fun fetchPhotos(): FlickrResponse
suspend fun fetchPhotos(): FlickrResponse

}
//
//https://pixabay.com/api/?key=40895557-d49a07cca955c5315c2bae711&q=bear&format=json&nojsoncallback=1

