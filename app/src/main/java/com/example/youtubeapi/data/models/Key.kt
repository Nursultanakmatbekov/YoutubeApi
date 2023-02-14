package com.example.youtubeapi.data.models

import com.google.gson.annotations.SerializedName

data class Key(
    @SerializedName("description")
    val description: String = "",
    @SerializedName("title")
    val title: String = ""
)