package step3

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CarGeneratorTest : FunSpec({
    test("generate()는 매개변수로 받은 개수만큼의 Car 객체를 정확한 번호로 반환해야 한다.") {
        // given
        val carCount = 3
        val expectedCars =
            listOf(
                Car(number = 1),
                Car(number = 2),
                Car(number = 3),
            )

        // when
        val actualCars = CarGenerator.generate(carCount)

        // then
        actualCars shouldBe expectedCars
    }
})
