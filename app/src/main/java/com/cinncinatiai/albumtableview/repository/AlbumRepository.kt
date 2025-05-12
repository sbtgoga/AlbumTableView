package com.cinncinatiai.albumtableview.repository

import com.cinncinatiai.albumtableview.model.AlbumModel
import com.cinncinatiai.albumtableview.network.AlbumApi
import com.cinncinatiai.albumtableview.network.NetworkClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface AlbumRepository {
    suspend fun getAlbums(): List<AlbumModel>
}

class AlbumRepositoryImpl(

    private val albumApi: AlbumApi = NetworkClient.albumApi
) : AlbumRepository {

    override suspend fun getAlbums(): List<AlbumModel> = withContext(Dispatchers.IO) {
        return@withContext albumApi.getAlbums()
    }


}
