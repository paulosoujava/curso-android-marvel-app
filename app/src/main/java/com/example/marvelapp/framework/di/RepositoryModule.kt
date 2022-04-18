package com.example.marvelapp.framework.di

import com.example.marvelapp.framework.CharactersRepositoryImpl
import com.example.marvelapp.framework.network.remote.RetrofitCharacterDataSource
import com.example.marvelapp.framework.network.response.DataWrapperResponse
import com.paulo.core.data.repository.CharacterRepository
import com.paulo.core.data.repository.CharactersRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindCharacterRepository(repositoryImpl: CharactersRepositoryImpl): CharacterRepository

    @Binds
    fun bindRemoteDataSource(
        dataSource: RetrofitCharacterDataSource
    ): CharactersRemoteDataSource<DataWrapperResponse>
}