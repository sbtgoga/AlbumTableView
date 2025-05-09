package com.cinncinatiai.albumtableview.Network

import com.cinncinatiai.albumtableview.Model.AlbumModel
import com.cinncinatiai.albumtableview.Model.AlbumResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/photos")
    fun getAlbum(): Call<AlbumResponse>
}