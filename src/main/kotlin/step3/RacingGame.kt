package step3

class RacingGame {
    fun execute(
        carCount: Int,
        moveCount: Int,
    ) {
        val cars = CarGenerator.generate(count = carCount)
        val completedCars = RacingProcessor.race(moveCount = moveCount, cars = cars)
        ResultPrinter.print(moveCount = moveCount, cars = completedCars)
    }
}
