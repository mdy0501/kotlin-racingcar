package step4

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import step4.domain.CarGenerator

class CarGeneratorTest : FunSpec({
    test("generate()는 매개변수로 받은 개수만큼의 Car 객체를 정확한 번호로 반환해야 한다.") {
        // given
        val givenCarNames = listOf("car1", "car2", "car3")

        // when
        val actualCars = CarGenerator.generate(givenCarNames)

        // then
        actualCars.size shouldBe givenCarNames.size
        actualCars.map { it.name } shouldBe givenCarNames
    }
})
