package com.example.youtubeapi.ui.fragments

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.youtubeapi.base.BaseViewModel
import com.example.youtubeapi.data.repository.VideoPopularRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PopularVideoViewModel @Inject constructor(private val repository: VideoPopularRepository) :
    BaseViewModel() {

    fun fetchVideosPopular(regionCode: String, chart: String, part: String) =
        repository.fetchVideosPopular(regionCode, chart, part).cachedIn(viewModelScope)
}