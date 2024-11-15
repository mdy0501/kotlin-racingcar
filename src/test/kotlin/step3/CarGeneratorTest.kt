package step3

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CarGeneratorTest : FunSpec({
    test("generate()는 매개변수로 받은 개수만큼의 Car의 리스트를 반환해야 한다.") {
        // given
        val carCount = 3

        // when
        val cars = CarGenerator().generate(carCount)

        // then
        cars.size shouldBe carCount
    }
})
