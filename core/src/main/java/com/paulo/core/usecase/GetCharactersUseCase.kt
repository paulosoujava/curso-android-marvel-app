package com.paulo.core.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.paulo.core.data.repository.CharacterRepository
import com.paulo.core.domain.model.Character
import com.paulo.core.usecase.base.PagingUseCase
import kotlinx.coroutines.flow.Flow

class GetCharactersUseCase constructor(
 private val charactersRepository: CharacterRepository
): PagingUseCase<GetCharactersUseCase.GetCharactersParams, Character>() {



    override fun createFlowObservable(params: GetCharactersParams): Flow<PagingData<Character>> {
        return Pager(
            config = params.pagingConfig
        ){
            charactersRepository.getCharacters(params.query)
        }.flow
    }

    data class GetCharactersParams(val query: String, val pagingConfig: PagingConfig)
}