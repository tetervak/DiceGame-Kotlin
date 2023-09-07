package ca.tetervak.dicegame

import ca.tetervak.dicegame.domain.FormatTimeStampUseCase
import ca.tetervak.dicegame.domain.GameUser
import ca.tetervak.dicegame.domain.GetRollDataUseCase
import java.util.*

class GameModel(
    val gameUser: GameUser,
    private val getRollData: GetRollDataUseCase,
    private val formatTimeStamp: FormatTimeStampUseCase
) {

    var gameState: GameState = GameState.NotRolled

    fun rollDice(numberOfDice: Int) {
        gameState = GameState.Rolled(getRollData(numberOfDice), Date())
    }

    fun reset() {
        gameState = GameState.NotRolled
    }

    override fun toString(): String {
        return when (val state = gameState) {
            is GameState.NotRolled -> "GameModel(gameUser = $gameUser, gameState = NotRolled)"
            is GameState.Rolled ->
                "GameModel(gameUser = $gameUser, gameState = Rolled(rollData = ${state.rollData}, date = ${
                    formatTimeStamp(
                        state.date
                    )
                }))"
        }
    }
}