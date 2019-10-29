package com.example.android.guesstheword.screens.score

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

/**
 * Created by charles on 26,October,2019
 */
class ScoreViewModel(finalScore:Int):ViewModel(){

    private val _score = MutableLiveData<Int>()
    val score:LiveData<Int>
         get() = _score

    private val _playAgain = MutableLiveData<Boolean>()
    val playAgain:LiveData<Boolean>
        get() = _playAgain

    init {
        Timber.i("Final score is $score")
        _score.value = finalScore
    }

    fun onPlayAgain(){
        _playAgain.value = true
    }

    fun onPlayAgainComplete(){
        _playAgain.value = false
    }
}