package com.android.composition.domain.usecases

import com.android.composition.domain.entity.Question
import com.android.composition.domain.repository.GameRepository


class GenerateQuestionUseCase(private val repository: GameRepository) {

    operator fun invoke(maxSumValue: Int): Question {
        return repository.generateQuestion(maxSumValue, COUNT_OF_OPTIONS)
    }

    private companion object {

        private const val COUNT_OF_OPTIONS = 6
    }
}
