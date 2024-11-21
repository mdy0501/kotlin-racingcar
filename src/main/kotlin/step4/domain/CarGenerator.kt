package step4.domain

object CarGenerator {
    fun generate(carNames: List<String>): List<Car> {
        return carNames.map { name -> Car.of(name) }
    }
}
