package com.example.myapplication


import androidx.lifecycle.ViewModel
import androidx.paging.*
import com.example.myapplication.api.FlickrAPI
import com.example.myapplication.api.GalleryItem
import kotlinx.coroutines.flow.Flow
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


//Tag that was used in the beginning of the project
//private const val TAG = "PhotoGalleryViewModel"




//PhotoGalleryViewModel class that extends ViewModel
//This part is in control of my pager and paging source
class PhotoGalleryViewModel: ViewModel() {

    private val flickrApi: FlickrAPI = Retrofit.Builder()


//Base Url for the API
        .baseUrl("https://api.flickr.com/")

//        .baseUrl("  https://pixabay.com/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(FlickrAPI::class.java)


//Function/Pager that is getting the photos from the API and defining the page size
    fun getPhotos(): Flow<PagingData<GalleryItem>> {
        return Pager(
            config = PagingConfig(
                pageSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                PhotoRepository.PhotoPagingSource(flickrApi)
            }
        ).flow

    }
}

