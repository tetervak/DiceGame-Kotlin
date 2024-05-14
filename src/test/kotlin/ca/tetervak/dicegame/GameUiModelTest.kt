package ca.tetervak.dicegame

import ca.tetervak.dicegame.data.service.RollerService
import ca.tetervak.dicegame.data.service.RollerServiceImpl
import ca.tetervak.dicegame.domain.GameUser
import ca.tetervak.dicegame.domain.GetRollDataUseCase
import ca.tetervak.dicegame.domain.UserLevel
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*

import kotlin.random.Random

class GameUiModelTest {

    private val gameUser = GameUser("Alex", UserLevel.INTERMEDIATE)
    private val rollerService: RollerService = RollerServiceImpl(Random(1))
    private val getRollData = GetRollDataUseCase(rollerService)
    private val gameUiModel = GameUiModel(gameUser, getRollData)

    init{
        println("gameUser = ${gameUiModel.gameUser}")
        println("gameState = ${gameUiModel.uiState}")
    }

    @BeforeEach
    fun setUp() {
        println("--- testing case ---")
    }

    @AfterEach
    fun tearDown() {
        println("--- ------- ---- ---")
    }


    @Test
    fun rollDice() {
        println("test rollDice()")
        println("before roll: gameState = ${gameUiModel.uiState}")
        assertTrue(gameUiModel.uiState is GameUiState.NotRolled)
        gameUiModel.rollDice(4)
        assertTrue(gameUiModel.uiState is GameUiState.Rolled)
        println("after roll: gameState = ${gameUiModel.uiState}")
    }

    @Test
    fun reset() {
        println("test reset()")
        gameUiModel.rollDice(4)
        println("after roll: gameState = ${gameUiModel.uiState}")
        gameUiModel.reset()
        assertTrue(gameUiModel.uiState is GameUiState.NotRolled)
        println("after reset: gameState = ${gameUiModel.uiState}")
    }
}