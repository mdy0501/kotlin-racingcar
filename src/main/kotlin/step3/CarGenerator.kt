package step3

class CarGenerator {
    fun generate(count: Int): List<Car> {
        val cars = mutableListOf<Car>()
        for (i in 1..count) {
            cars.add(Car(number = i))
        }
        return cars
    }
}
