package ca.tetervak.dicegame

import ca.tetervak.dicegame.domain.RollData
import java.util.Date

sealed interface GameState {
    data object NotRolled: GameState

    data class Rolled(val rollData: RollData, val date: Date): GameState
}