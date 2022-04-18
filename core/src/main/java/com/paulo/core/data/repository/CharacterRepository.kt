package com.paulo.core.data.repository

import androidx.paging.PagingSource
import com.paulo.core.domain.model.Character

interface CharacterRepository {

    fun getCharacters(query: String): PagingSource<Int,Character>
}