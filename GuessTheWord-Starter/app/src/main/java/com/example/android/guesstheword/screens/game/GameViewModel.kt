package com.example.android.guesstheword.screens.game

import androidx.lifecycle.ViewModel
import timber.log.Timber

/**
 * Created by charles on 23,October,2019
 */
class GameViewModel:ViewModel() {
    // The current word
     var word = ""

    // The current score
     var score = 0
    private lateinit var wordList: MutableList<String>

    init {
        Timber.i("Game ViewModel Created")
        resetList()
        nextWord()
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("Game ViewModel destroyed")
    }

    private fun resetList() {
        wordList = mutableListOf(
               "Tha.doc",
                "Charmyrreah",
                "Madea",
                "laptop",
                "programing",
                "shoelace",
                "briefcase",
                "glasses",
                "hat",
                "lava lamp",
                "Books",
                "Tv",
                "Jacket",
                "cat",
                "paper",
                "table",
                "Phone",
                "socks",
                "Light",
                "Shirt",
                "song",
                "Fan",
                "Art",
                "Math",
                "Desk",
                "catfood",
                "Xbox",
                "Heatetr",
                "Spongebob",
                "Tupac",
                "Ice cube",
                "Wall",
                "ZAZA",
                "Halloween",
                "Snake",
                "Wifi",
                "CD",
                "Bowl",
                "Work"
        )
        wordList.shuffle()
    }

    private fun nextWord() {
        if (wordList.isNotEmpty()) {
            //Select and remove a word from the list
            word = wordList.removeAt(0)
        }

    }

     fun onSkip() {
        if (wordList.isNotEmpty()) {
            score--
        }
        nextWord()
    }

     fun onCorrect() {
        if (wordList.isNotEmpty()) {
            score++
        }
        nextWord()
    }
}