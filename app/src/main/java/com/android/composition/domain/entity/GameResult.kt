package com.android.composition.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import ru.sumin.composition.domain.entity.GameSettings

@Parcelize
data class GameResult(
    val winner: Boolean,
    val countOfRightAnswers: Int,
    val countOfQuestions: Int,
    val gameSettings: GameSettings
) : Parcelable
