package com.example.youtubeapi.data.models

import com.google.gson.annotations.SerializedName

data class Thumbnails(
    @SerializedName("standard")
    val standard: Standard,
)