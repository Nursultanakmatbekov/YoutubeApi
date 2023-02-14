package com.example.youtubeapi.data.models

import com.google.gson.annotations.SerializedName

data class RecordingDetails(
    @SerializedName("recordingDate")
    val recordingDate: String = ""
)