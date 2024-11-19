package step4.domain

object WinnerFinder {
    fun get(cars: List<Car>): List<String> {
        val count = cars.maxOf { it.getForwardMoveCount() }
        return cars.filter { it.getForwardMoveCount() == count }
            .map { it.name }
    }
}
