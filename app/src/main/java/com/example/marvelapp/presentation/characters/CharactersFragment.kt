package com.example.marvelapp.presentation.characters

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.marvelapp.R
import com.example.marvelapp.databinding.FragmentCharactersBinding
import com.paulo.core.domain.model.Character
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharactersFragment : Fragment() {

    private var _binding: FragmentCharactersBinding? = null
    private val binding: FragmentCharactersBinding get() = _binding!!

    private val characterAdapter = CharacterAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentCharactersBinding.inflate(
        inflater,
        container,
        false
    ).apply {
        _binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        iniCharactersAdapter()

        characterAdapter.submitList(
            listOf(
                Character("3D-Man",
                    "https://cdn.pocket-lint.com/r/s/1200x630/assets/images/159643-tv-news-spider-man-no-way-home-image1-dryautoefj.jpg"),
                Character("3D-Man","https://cdn.pocket-lint.com/r/s/1200x630/assets/images/159643-tv-news-spider-man-no-way-home-image1-dryautoefj.jpg"),
                Character("3D-Man","https://cdn.pocket-lint.com/r/s/1200x630/assets/images/159643-tv-news-spider-man-no-way-home-image1-dryautoefj.jpg"),
            )
        )
    }

    fun iniCharactersAdapter(){
        with(binding.recyclerCharacter){
            setHasFixedSize(true)
            adapter = characterAdapter
        }
    }
}