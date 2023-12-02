package com.example.myapplication

import android.util.Log
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import androidx.recyclerview.widget.DiffUtil
import com.example.myapplication.api.FlickrAPI
import com.example.myapplication.api.GalleryItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val TAG = "PhotoGalleryViewModel"




//PhotoGalleryViewModel function that needs to work

class PhotoGalleryViewModel: ViewModel() {

    private val flickrApi: FlickrAPI = Retrofit.Builder()
        .baseUrl("https://api.flickr.com/")



//      .baseUrl("https://pixabay.com/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(FlickrAPI::class.java)

    fun getPhotos(): Flow<PagingData<GalleryItem>> {
        return Pager(
            config = PagingConfig(
                pageSize = 100,
                enablePlaceholders = true
            ),
            pagingSourceFactory = { PhotoRepository.PhotoPagingSource(flickrApi) }
        ).flow

    }
}

