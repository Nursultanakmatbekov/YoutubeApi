package com.example.youtubeapi.data.models

import com.google.gson.annotations.SerializedName

data class TopicDetails(
    @SerializedName("relevantTopicIds")
    val relevantTopicIds: List<String>?,
    @SerializedName("topicIds")
    val topicIds: List<String>?,
    @SerializedName("topicCategories")
    val topicCategories: List<String>?
)