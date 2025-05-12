package com.cinncinatiai.albumtableview.network

import com.cinncinatiai.albumtableview.model.AlbumModel
import retrofit2.http.GET

interface AlbumApi {
    @GET("/photos")
    suspend fun getAlbums(): List<AlbumModel>
}