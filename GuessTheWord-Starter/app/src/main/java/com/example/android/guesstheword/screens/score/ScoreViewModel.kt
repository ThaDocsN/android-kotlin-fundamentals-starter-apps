package com.example.android.guesstheword.screens.score

import androidx.lifecycle.ViewModel
import timber.log.Timber

/**
 * Created by charles on 26,October,2019
 */
class ScoreViewModel(finalScore:Int):ViewModel(){

    var score = finalScore
    init {
        Timber.i("Final score is $score")
    }
}