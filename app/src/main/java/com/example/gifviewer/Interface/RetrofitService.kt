package com.example.gifviewer.Interface

import com.example.gifviewer.Model.Data
import com.example.gifviewer.Model.Gifs
//import com.example.gifviewer.Model.Gifs
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("search?api_key=YGHnKKBGSydS6nSt6WAoUcICWwmgCfvL&q=hello&limit=25&offset=0&rating=g&lang=en")
    fun getGifList(): Call<Gifs>
}