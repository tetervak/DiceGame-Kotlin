import ca.tetervak.dicegame.data.service.RollerService
import ca.tetervak.dicegame.data.service.RollerServiceImpl
import ca.tetervak.dicegame.domain.RollData

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

}