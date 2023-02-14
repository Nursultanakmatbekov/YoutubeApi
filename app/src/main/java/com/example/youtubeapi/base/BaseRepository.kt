package com.example.youtubeapi.base

import androidx.lifecycle.liveData
import com.example.youtubeapi.ui.utils.Resources

abstract class BaseRepository {

    protected open fun <T> doRequest(request: suspend () -> T) = liveData {
        emit(Resources.Loading())
        try {
            emit(Resources.Success(request()))
        } catch (ioException: Exception) {
            emit(Resources.Error(ioException.localizedMessage ?: "Error"))
        }
    }
}