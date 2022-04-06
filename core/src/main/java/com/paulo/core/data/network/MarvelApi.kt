package com.paulo.core.data.network

import com.paulo.core.data.network.response.DataWrapperResponse
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface MarvelApi {

    @GET("characters")
    suspend fun getCharacter(
        @QueryMap
        queries: Map<String, String>
    ): DataWrapperResponse
}