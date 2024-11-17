package step4

object CarGenerator {
    fun generate(carNames: List<String>): List<Car> {
        return carNames.map { name -> Car.of(name) }
    }
}
