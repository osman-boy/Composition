package com.android.composition.presentation

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.composition.domain.entity.Level

/**
 * Created by osmanboy on 2/19/2022.
 */

class GameViewModelFactory(private val application: Application, private val level: Level) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return GameViewModel(application, level) as T
    }

}