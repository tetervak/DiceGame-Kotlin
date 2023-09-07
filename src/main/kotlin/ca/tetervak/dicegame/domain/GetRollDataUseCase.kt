package ca.tetervak.dicegame.domain

import ca.tetervak.dicegame.data.service.RollerService

class GetRollDataUseCase(
    private val rollerService: RollerService
) {
    operator fun invoke(numberOfDice: Int) = rollerService.getRollData(numberOfDice)
}