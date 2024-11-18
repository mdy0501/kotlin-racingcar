package step4

class RacingGame {
    fun execute(
        carNames: List<String>,
        moveCount: Int,
    ) {
        val cars = CarGenerator.generate(carNames = carNames)
        val completedCars = RacingProcessor.race(moveCount = moveCount, cars = cars)
        ResultPrinter.print(moveCount = moveCount, cars = completedCars)
    }
}
