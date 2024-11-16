package step3

class RacingProcessor(private val cars: List<Car>) {
    fun race(moveCount: Int): List<RacingResult> {
        // Car 번호를 기반으로 RacingResult 초기화
        val results = this.prepareRacingResults()

        // moveCount만큼 레이스 실행
        repeat(moveCount) {
            cars.forEachIndexed { index, car ->
                val moveStatus = car.move()
                results[index].addHistory(moveStatus)
            }
        }

        return results
    }

    private fun prepareRacingResults(): List<RacingResult> {
        return cars.map { RacingResult(it.number) }
    }
}
