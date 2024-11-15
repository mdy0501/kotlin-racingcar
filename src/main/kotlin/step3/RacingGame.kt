package step3

class RacingGame {
    fun execute(
        carCount: Int,
        moveCount: Int,
    ) {
        val cars = CarGenerator().generate(count = carCount)
        val racingResults = RacingProcessor(cars = cars).race(moveCount = moveCount)
        ResultPrinter.print(moveCount = moveCount, racingResults = racingResults)
    }
}
