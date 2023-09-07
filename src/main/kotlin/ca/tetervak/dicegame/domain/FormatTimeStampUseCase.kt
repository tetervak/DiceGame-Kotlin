package ca.tetervak.dicegame.domain

import ca.tetervak.dicegame.util.formatDateAndTime
import java.util.*

class FormatTimeStampUseCase {
    operator fun invoke(date: Date) = formatDateAndTime(date)
}