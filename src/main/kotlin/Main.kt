import ca.tetervak.dicegame.data.service.RollerService
import ca.tetervak.dicegame.data.service.RollerServiceImpl
import ca.tetervak.dicegame.domain.GameUser
import ca.tetervak.dicegame.domain.RollData
import ca.tetervak.dicegame.domain.UserLevel

fun main(args: Array<String>) {
    println("Hello Dice Game!")

    println("*** Testing RollData:")
    val rollData = RollData(listOf(4,3,5))
    println("rollData = $rollData")

    println("*** Testing RollerService:")
    val rollerService: RollerService = RollerServiceImpl()
    for(numberOfDice in 1..5){
        for(rollCount in 1..3){
            val roll = rollerService.getRollData(numberOfDice)
            println("roll $rollCount of $numberOfDice dice = $roll")
        }
    }

    println("*** Testing GameUser:")
    val gameUser = GameUser("Alex", UserLevel.INTERMEDIATE)
    println("gameUser = $gameUser")

}