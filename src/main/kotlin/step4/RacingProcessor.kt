package step4

object RacingProcessor {
    fun race(
        moveCount: Int,
        cars: List<Car>,
    ): List<Car> {
        // moveCount만큼 레이스 실행
        repeat(moveCount) {
            cars.forEach { car ->
                car.move(moveFactor = RandomGenerator.generate())
            }
        }

        return cars
    }
}
