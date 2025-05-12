package com.cinncinatiai.albumtableview.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkClient {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val albumApi: AlbumApi by lazy {
        retrofit.create(AlbumApi::class.java)
    }

}