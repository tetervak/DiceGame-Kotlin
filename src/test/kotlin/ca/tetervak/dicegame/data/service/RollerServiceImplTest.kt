package ca.tetervak.dicegame.data.service

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import java.lang.IllegalArgumentException
import kotlin.random.Random

class RollerServiceImplTest {

    private val random: Random = Random(seed = 10)
    private val rollerService: RollerService = RollerServiceImpl(random)

    @BeforeEach
    fun setUp() {
        println("--- testing case ---")
    }

    @AfterEach
    fun tearDown() {
        println("--- ------- ---- ---")
    }

    @Test
    fun getRollData(){
        for(numberOfDice: Int in 1..4){
            for(repetition: Int in 1..5){
                println("test getNumberOfDice($numberOfDice) repetition $repetition")
                val rollData = rollerService.getRollData(numberOfDice)
                println("rollData = $rollData")
                assertEquals(numberOfDice, rollData.numberOfDice)
                val values = rollData.values
                for(value in values){
                    assert(value > 0)
                    assert(value <= 6)
                }
            }
        }
    }

    @Test
    fun getRollData_ZeroDice(){
        println("test throwing exception for getRollData(numberOfDice = 0)")
        assertThrows<IllegalArgumentException> {
            val rollData = rollerService.getRollData(numberOfDice = 0)
            println("rollData = $rollData")
        }
    }
}