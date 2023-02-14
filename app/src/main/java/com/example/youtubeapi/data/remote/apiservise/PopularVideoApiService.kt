package com.example.youtubeapi.data.remote.apiservise

import com.example.youtubeapi.data.models.PopularVideo
import com.example.youtubeapi.data.models.VideoResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PopularVideoApiService {

    @GET("videos")
    suspend fun fetchPopularVideos(
        @Query("regionCode") regionCode: String,
        @Query("chart") chart: String,
        @Query("part") part: String,
        @Query("pageToken") nextPageToken: String
    ): VideoResponse<PopularVideo>
}