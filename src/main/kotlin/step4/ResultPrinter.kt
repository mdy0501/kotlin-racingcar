package step4

object ResultPrinter {
    fun print(
        moveCount: Int,
        cars: List<Car>,
    ) {
        this.printRacingResult(moveCount, cars)
        this.printWinners(cars)
    }

    private fun printRacingResult(
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

    private fun printWinners(cars: List<Car>) {
        val winners = WinnerFinder.get(cars = cars)
        println("최종 우승자: ${winners.joinToString()}")
    }
}
