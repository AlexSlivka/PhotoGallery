package com.example.photogallery.api

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

//https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=xxx&format=json&nojsoncallback=1&extras=url_s&safe_search=1&text=cat
private const val API_KEY = "6a6f62452d3cdc2fc88c7ff664d7e764"

class PhotoInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest: Request = chain.request()

        val newUrl: HttpUrl = originalRequest.url().newBuilder()
            .addQueryParameter(
                "api_key",
                API_KEY
            )
            .addQueryParameter(
                "format",
                "json"
            )
            .addQueryParameter("nojsoncallback", "1")
            .addQueryParameter("extras", "url_s")
            .addQueryParameter("safesearch", "1")
            .build()

        val newRequest: Request = originalRequest.newBuilder()
            .url(newUrl)
            .build()

        return chain.proceed(newRequest)
    }
}