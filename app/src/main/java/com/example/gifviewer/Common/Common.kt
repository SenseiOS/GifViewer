package com.example.gifviewer.Common

import com.example.gifviewer.Interface.RetrofitService
import com.example.gifviewer.Retrofit.RetrofitClient

object Common {
    private val BASE_URL = "https://api.giphy.com/v1/gifs/"

    val retrofitService: RetrofitService
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitService::class.java)
}