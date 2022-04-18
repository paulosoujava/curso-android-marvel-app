package com.example.marvelapp.presentation.characters


import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.paulo.core.domain.model.Character

class CharacterAdapter: PagingDataAdapter<Character, CharacterViewHolder>(diffCalback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    companion object {
        private val diffCalback = object : DiffUtil.ItemCallback<Character>(){
            override fun areContentsTheSame(
                oldItem: Character,
                newItem: Character
            ): Boolean {
               return oldItem.name == newItem.name
            }

            override fun areItemsTheSame(
                oldItem: Character,
                newItem: Character
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

}