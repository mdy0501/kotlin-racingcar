package step3

object ResultPrinter {
    fun print(
        moveCount: Int,
        cars: List<Car>,
    ) {
        repeat(moveCount) { i ->
            cars.forEach { car ->
                println(car.getForwardMoveHistory(i + 1))
            }
            println()
        }
    }
}
