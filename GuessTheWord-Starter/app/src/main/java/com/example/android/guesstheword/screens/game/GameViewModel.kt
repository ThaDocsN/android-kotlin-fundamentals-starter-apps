package com.example.android.guesstheword.screens.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

/**
 * Created by charles on 23,October,2019
 */
class GameViewModel:ViewModel() {
    // The current word
     private val _word = MutableLiveData<String>()
    val word: LiveData<String>
        get() = _word

    // The current score
     private val _score = MutableLiveData<Int>()
    val score:LiveData<Int>
        get() = _score

    private val _eventGameFinish = MutableLiveData<Boolean>()
    val eventGameFinish:LiveData<Boolean>
        get() = _eventGameFinish

    private lateinit var wordList: MutableList<String>

    init {
        Timber.i("Game ViewModel Created")
        _word.value = ""
        _score.value = 0
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
                "Heater",
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

    fun onGameFinishComplete(){
        _eventGameFinish.value = false
    }

    fun onGameFinished(){
        _eventGameFinish.value = true
    }

    private fun nextWord() {
        if (wordList.isNotEmpty()) {
            //Select and remove a word from the list
            _word.value = wordList.removeAt(0)
        }else{
            onGameFinished()
        }

    }

     fun onSkip() {
        if (wordList.isNotEmpty()) {
            _score.value = score.value?.minus(1)
        }
        nextWord()
    }

     fun onCorrect() {
        if (wordList.isNotEmpty()) {
            _score.value = score.value?.plus(1)
        }
        nextWord()
    }
}