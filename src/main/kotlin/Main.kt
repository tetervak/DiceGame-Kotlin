import ca.tetervak.dicegame.domain.RollData

fun main(args: Array<String>) {
    println("Hello Dice Game!")

    val rollData = RollData(listOf(4,3,5))

    println("rollData = $rollData")
}