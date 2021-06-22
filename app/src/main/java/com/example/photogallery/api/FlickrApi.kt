package com.example.photogallery.api

import retrofit2.Call
import retrofit2.http.GET

private const val ApiKey = "6a6f62452d3cdc2fc88c7ff664d7e764"
private const val ApiKeySecret = "0cf131c6204bd2d3"

interface FlickrApi {

    @GET(
        "services/rest/?method=flickr.interestingness.getList" +
                "&api_key=6a6f62452d3cdc2fc88c7ff664d7e764" +
                "&format=json" +
                "&nojsoncallback=1" +
                "&extras=url_s"
    )
    fun fetchPhotos(): Call<FlickrResponse>
}