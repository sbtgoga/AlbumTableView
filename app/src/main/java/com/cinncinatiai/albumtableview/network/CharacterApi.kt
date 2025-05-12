package com.cinncinatiai.albumtableview.network

import com.cinncinatiai.albumtableview.model.CharacterResponse
import retrofit2.http.GET

interface CharacterApi {
    @GET("character")
    suspend fun getCharacters(): CharacterResponse
}