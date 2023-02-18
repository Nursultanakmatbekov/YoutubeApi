package com.example.youtubeapi.data.remote

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url = request.url.newBuilder()
            .addQueryParameter("Key", "AIzaSyBI5eCr4gEjREBVK1fBjxlw0aIjxKlQsKw").build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}