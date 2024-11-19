package step4.view

import step4.domain.Car
import step4.domain.WinnerFinder

object OutputView {
    fun printRacingResult(
        moveCount: Int,
        cars: List<Car>,
    ) {
        println("실행 결과")
        repeat(moveCount) { i ->
            cars.forEach { car ->
                println("${car.name} : ${car.getForwardMoveHistory(i + 1)}")
            }
            println()
        }
    }

    fun printWinners(cars: List<Car>) {
        val winners = WinnerFinder.get(cars)
        println("최종 우승자: ${winners.joinToString()}")
    }
}
