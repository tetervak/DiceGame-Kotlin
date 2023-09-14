package ca.tetervak.dicegame

import ca.tetervak.dicegame.domain.GameUser
import ca.tetervak.dicegame.domain.GetRollDataUseCase
import java.util.*

class GameModel(
    val gameUser: GameUser,
    private val getRollData: GetRollDataUseCase
) {

    var gameState: GameState = GameState.NotRolled

    fun rollDice(numberOfDice: Int) {
        gameState = GameState.Rolled(getRollData(numberOfDice), Date())
    }

    fun reset() {
        gameState = GameState.NotRolled
    }
}