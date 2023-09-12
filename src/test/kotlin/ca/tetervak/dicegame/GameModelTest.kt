package ca.tetervak.dicegame

import ca.tetervak.dicegame.data.service.RollerService
import ca.tetervak.dicegame.data.service.RollerServiceImpl
import ca.tetervak.dicegame.domain.GameUser
import ca.tetervak.dicegame.domain.GetRollDataUseCase
import ca.tetervak.dicegame.domain.UserLevel
import org.junit.jupiter.api.*

import kotlin.random.Random

class GameModelTest {

    companion object {
        @JvmStatic
        @BeforeAll
        fun startAll() {
            println("--- Starting GameModel Tests ---")
        }

        @JvmStatic
        @AfterAll
        fun endAll() {
            println("--- End of GameModel Tests ---")
        }
    }

    private val gameUser = GameUser("Alex", UserLevel.INTERMEDIATE)
    private val rollerService: RollerService = RollerServiceImpl(Random(1))
    private val getRollData = GetRollDataUseCase(rollerService)
    private val gameModel = GameModel(gameUser, getRollData)

    init{
        println("gameUser = ${gameModel.gameUser}")
        println("gameState = ${gameModel.gameState}")
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
        println("before roll: gameState = ${gameModel.gameState}")
        assert(gameModel.gameState is GameState.NotRolled)
        gameModel.rollDice(4)
        assert(gameModel.gameState is GameState.Rolled)
        println("after roll: gameState = ${gameModel.gameState}")
    }

    @Test
    fun reset() {
        println("test reset()")
        gameModel.rollDice(4)
        println("after roll: gameState = ${gameModel.gameState}")
        gameModel.reset()
        assert(gameModel.gameState is GameState.NotRolled)
        println("after reset: gameState = ${gameModel.gameState}")
    }
}