package com.example.youtubeapi.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.youtubeapi.data.models.PopularVideo
import com.excample.youtubeapi.databinding.ItemVideoBinding

class PopularVideoAdapter :
    PagingDataAdapter<PopularVideo, PopularVideoAdapter.VideoViewHolder>(diffUtil) {

    inner class VideoViewHolder(private val binding: ItemVideoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: PopularVideo) = with(binding) {
            Glide.with(imView.context)
                .load(item.snippet.thumbnails.standard.url)
                .into(imView)
            binding.tvName.text = item.snippet.channelTitle
            binding.tvTitle.text = item.snippet.title
        }

        init {
            itemView.setOnClickListener {
                getItem(bindingAdapterPosition)?.apply {
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        return VideoViewHolder(
            ItemVideoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        getItem(position)?.let {
            holder.onBind(it)
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<PopularVideo>() {
            override fun areItemsTheSame(oldItem: PopularVideo, newItem: PopularVideo): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: PopularVideo, newItem: PopularVideo): Boolean {
                return oldItem == newItem
            }
        }
    }
}