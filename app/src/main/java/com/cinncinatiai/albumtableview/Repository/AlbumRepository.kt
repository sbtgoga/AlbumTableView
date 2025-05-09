package com.cinncinatiai.albumtableview.Repository

import com.cinncinatiai.albumtableview.Model.AlbumModel
import com.cinncinatiai.albumtableview.Model.AlbumResponse
import com.cinncinatiai.albumtableview.Network.ApiService
import com.cinncinatiai.albumtableview.Network.RetrofitClient.api
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import retrofit2.Call

interface AlbumRepository {
    fun getAlbums(): List<AlbumModel>
}

class AlbumRepositoryImpl(
    //Default Implementation; I am depending on GSON
    private val gson: Gson = Gson()
) : AlbumRepository {

    override fun getAlbums(): List<AlbumModel> {

        val retrofitAPI = api.create(ApiService::class.java)

        val call: Call<AlbumResponse> = retrofitAPI.getAlbum()

        val typeToken = object : TypeToken<List<AlbumModel>>() {}.type
        val albums = gson.fromJson<List<AlbumModel>>(call, typeToken)

        return albums
    }

}
