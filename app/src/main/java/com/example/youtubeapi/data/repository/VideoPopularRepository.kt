package com.example.youtubeapi.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.youtubeapi.base.BaseRepository
import com.example.youtubeapi.data.pagingsource.PopularVideoPagingSource
import com.example.youtubeapi.data.remote.apiservise.PopularVideoApiService
import javax.inject.Inject

class VideoPopularRepository @Inject constructor(private val service: PopularVideoApiService) :
    BaseRepository() {

    fun fetchVideosPopular(regionCode: String, chart: String, part: String) =
        Pager(PagingConfig(pageSize = 10, enablePlaceholders = false)) {
            PopularVideoPagingSource(service, regionCode, chart, part)
        }.liveData
}