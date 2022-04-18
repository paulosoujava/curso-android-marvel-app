package com.example.marvelapp.presentation.characters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelapp.databinding.ItemCharacterBinding
import com.example.marvelapp.databinding.LoadMoreBinding

class CharactersLoadMoreStateViewHolder(
    itemBinding: LoadMoreBinding,
    retry: () -> Unit
) : RecyclerView.ViewHolder(itemBinding.root) {

    private val binding = LoadMoreBinding.bind(itemView)
    private val progressBarLoadingMore = binding.progressLoadingMore
    private val textErrorTryAgainMessage = binding.textTryAgain.also {
        it.setOnClickListener {
            retry()
        }
    }

    fun bind(loadState: LoadState) {
        progressBarLoadingMore.isVisible = loadState is LoadState.Loading
        textErrorTryAgainMessage.isVisible = loadState is LoadState.Error
    }

    companion object {
        fun create(parent: ViewGroup, retry: () -> Unit): CharactersLoadMoreStateViewHolder{
            val itemBinding = LoadMoreBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
            return CharactersLoadMoreStateViewHolder(itemBinding, retry)
        }
    }
}