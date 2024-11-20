package step4.view

import step4.domain.Car
import step4.domain.MoveStatus

object OutputView {
    fun printRacingResult(
        moveCount: Int,
        cars: List<Car>,
    ) {
        println("실행 결과")
        repeat(moveCount) { i ->
            cars.forEach { car ->
                println(formatCarMovement(car, i + 1))
            }
            println()
        }
    }

    fun printWinners(winners: List<String>) {
        println("최종 우승자: ${winners.joinToString()}")
    }

    private fun formatCarMovement(
        car: Car,
        moveIndex: Int,
    ): String {
        val moveHistory =
            car.getForwardMoveHistory(moveIndex)
                .joinToString("") { it.toDisplay() }
        return "${car.name} : $moveHistory"
    }

    private fun MoveStatus.toDisplay(): String {
        return when (this) {
            MoveStatus.FORWARD -> "-"
            MoveStatus.STAY -> ""
        }
    }
}
