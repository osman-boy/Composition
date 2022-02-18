package com.android.composition.domain.usecases

import com.android.composition.domain.entity.Level
import com.android.composition.domain.repository.GameRepository
import com.android.composition.domain.entity.GameSettings

class GetGameSettingsUseCase(private val repository: GameRepository) {

    operator fun invoke(level: Level): GameSettings {
        return repository.getGameSettings(level)
    }
}
