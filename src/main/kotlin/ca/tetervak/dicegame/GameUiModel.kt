package ca.tetervak.dicegame

import ca.tetervak.dicegame.domain.GameUser
import ca.tetervak.dicegame.domain.GetRollDataUseCase
import java.util.*

class GameUiModel(
    val gameUser: GameUser,
    private val getRollData: GetRollDataUseCase
) {

    var uiState: GameUiState = GameUiState.NotRolled

    fun rollDice(numberOfDice: Int) {
        uiState = GameUiState.Rolled(getRollData(numberOfDice), Date())
    }

    fun reset() {
        uiState = GameUiState.NotRolled
    }
}