package ca.tetervak.dicegame

import ca.tetervak.dicegame.domain.RollData
import ca.tetervak.dicegame.util.formatDateAndTime
import java.util.Date

sealed interface GameUiState {

    data object NotRolled: GameUiState

    data class Rolled(val rollData: RollData, val date: Date): GameUiState {
        override fun toString(): String {
            return "Rolled(rollData=$rollData, date=\"${formatDateAndTime(date)}\")"
        }
    }
}