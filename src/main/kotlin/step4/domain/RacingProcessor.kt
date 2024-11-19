package step4.domain

class RacingProcessor(
    private val randomGenerator: RandomGenerator,
) {
    fun race(
        moveCount: Int,
        cars: List<Car>,
    ): List<Car> {
        // moveCount만큼 레이스 실행
        repeat(moveCount) {
            cars.forEach { car ->
                car.move(moveFactor = randomGenerator.generate())
            }
        }

        return cars
    }
}
