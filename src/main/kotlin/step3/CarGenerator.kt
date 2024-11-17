package step3

object CarGenerator {
    fun generate(count: Int): List<Car> {
        return List(count) { index -> Car(number = index + 1) }
    }
}
