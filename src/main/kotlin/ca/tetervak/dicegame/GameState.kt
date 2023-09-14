package ca.tetervak.dicegame

import ca.tetervak.dicegame.domain.RollData
import ca.tetervak.dicegame.util.formatDateAndTime
import java.util.Date

sealed interface GameState {
    data object NotRolled: GameState {
        override fun toString(): String {
            return "NotRolled()"
        }
    }

    data class Rolled(val rollData: RollData, val date: Date): GameState {
        override fun toString(): String {
            return "Rolled(rollData=$rollData, date=\"${formatDateAndTime(date)}\")"
        }
    }

}