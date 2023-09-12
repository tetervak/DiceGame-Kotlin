import ca.tetervak.dicegame.GameModel
import ca.tetervak.dicegame.data.service.RollerService
import ca.tetervak.dicegame.data.service.RollerServiceImpl
import ca.tetervak.dicegame.domain.*
import kotlin.random.Random

fun main(args: Array<String>) {
    println("Hello Dice Game!")

    println("*** Testing RollData:")
    val rollData = RollData(listOf(4,3,5))
    println("rollData = $rollData")

    println("*** Testing RollerService:")
    val rollerService: RollerService = RollerServiceImpl(Random(1))
    for(numberOfDice in 1..5){
        for(rollCount in 1..3){
            val roll = rollerService.getRollData(numberOfDice)
            println("roll $rollCount of $numberOfDice dice = $roll")
        }
    }

    println("*** Testing GameUser:")
    val gameUser = GameUser("Alex", UserLevel.INTERMEDIATE)
    println("gameUser = $gameUser")
//
//    println("*** testing GetRollDataUseCase")
//    val getRollData = GetRollDataUseCase(rollerService)
//    for(rollCount in 1..3){
//        val roll = getRollData(3)
//        println("roll $rollCount = $roll")
//    }
//
//    println("*** testing GameModel:")
//    val gameModel = GameModel(gameUser, getRollData)
//    println("gameUser = ${gameModel.gameUser}")
//    println("before roll: gameState = ${gameModel.gameState}")
//    gameModel.rollDice(4)
//    println("after roll: gameState = ${gameModel.gameState}")
//    gameModel.reset()
//    println("after reset: gameState = ${gameModel.gameState}")

}