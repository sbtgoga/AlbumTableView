package com.cinncinatiai.albumtableview.repository

import com.cinncinatiai.albumtableview.model.CharacterResponse
import com.cinncinatiai.albumtableview.network.CharacterApi
import com.cinncinatiai.albumtableview.network.NetworkClientRickAndMorty
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface CharacterRepository {
    suspend fun getCharacters(): CharacterResponse
}

class CharacterRepositoryImpl(

    private val characterApi: CharacterApi = NetworkClientRickAndMorty.characterApi
) : CharacterRepository {

    override suspend fun getCharacters(): CharacterResponse = withContext(Dispatchers.IO) {
        return@withContext characterApi.getCharacters()
    }


}
