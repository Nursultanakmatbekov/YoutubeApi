package com.example.youtubeapi.ui.utils

sealed class Resources<out T>(
    val data: T? = null,
    val message: String? = null
) {

    class Loading<T>(data: T? = null) : Resources<T>(data = data)
    class Success<T>(data: T) : Resources<T>(data = data)
    class Error<T>(message: String, data: T? = null) : Resources<T>(data = data, message = message)
}