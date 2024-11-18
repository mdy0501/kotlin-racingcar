package step4

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.ranges.shouldBeIn

class RandomGeneratorTest : FunSpec({
    test("generate()는 0부터 9까지의 랜덤한 숫자를 반환해야 한다.") {
        // given
        val expectedRange = 0..9

        // when
        val actualNumber = RandomGenerator.generate()

        // then
        actualNumber shouldBeIn expectedRange
    }
})
