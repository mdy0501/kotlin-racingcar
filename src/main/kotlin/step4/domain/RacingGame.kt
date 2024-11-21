package step4.domain

class RacingGame(
    private val randomGenerator: RandomGenerator,
) {
    fun execute(
        carNames: List<String>,
        moveCount: Int,
    ): List<Car> {
        val cars = CarGenerator.generate(carNames = carNames)
        val completedCars = RacingProcessor(randomGenerator).race(moveCount = moveCount, cars = cars)
        return completedCars
    }
}
