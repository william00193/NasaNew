package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.*
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.api.GalleryItem
import com.example.myapplication.databinding.FragmentPhotoGalleryBinding
import com.example.myapplication.databinding.ListItemGalleryBinding
import kotlinx.coroutines.launch


private const val TAG = "PhotoGalleryFragment"

class PhotoGalleryFragment : Fragment() {

    private var _binding: FragmentPhotoGalleryBinding? = null
    private val binding get() = _binding!!

    private val photoGalleryViewModel: PhotoGalleryViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPhotoGalleryBinding.inflate(inflater, container, false)
        binding.photoGrid.layoutManager = GridLayoutManager(context, 3)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val photoListAdapter = PhotoListAdapter()
        binding.photoGrid.adapter = photoListAdapter
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                photoGalleryViewModel.getPhotos().collect { pagingData ->
                    photoListAdapter.submitData(pagingData)
                }
            }
        }
    }

    class PhotoListAdapter : PagingDataAdapter<GalleryItem, PhotoViewHolder>(PHOTO_COMPARATOR) {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
            val binding =
                ListItemGalleryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return PhotoViewHolder(binding)

        }

        override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
            val currentItem = getItem(position)
            if (currentItem != null) {
                holder.bind(currentItem)
            }
        }
    }

    object PHOTO_COMPARATOR : DiffUtil.ItemCallback<GalleryItem>() {
        override fun areItemsTheSame(oldItem: GalleryItem, newItem: GalleryItem): Boolean {
            return oldItem.id == newItem.id

        }

        override fun areContentsTheSame(oldItem: GalleryItem, newItem: GalleryItem): Boolean {
            return oldItem == newItem
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

