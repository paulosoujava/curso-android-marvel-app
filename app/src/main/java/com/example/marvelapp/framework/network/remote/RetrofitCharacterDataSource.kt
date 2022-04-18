package com.example.marvelapp.framework.network.remote

import com.example.marvelapp.framework.network.MarvelApi
import com.example.marvelapp.framework.network.response.DataWrapperResponse
import com.paulo.core.data.repository.CharactersRemoteDataSource
import javax.inject.Inject

class RetrofitCharacterDataSource @Inject constructor(
    private val marvelApi: MarvelApi
): CharactersRemoteDataSource<DataWrapperResponse> {

    override suspend fun fetchCharacters(queries: Map<String, String>): DataWrapperResponse {
        return marvelApi.getCharacter(queries)
    }
}