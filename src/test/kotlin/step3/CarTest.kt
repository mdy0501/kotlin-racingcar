package step3

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldBeOneOf

class CarTest : FunSpec({
    test("move()는 FORWARD 또는 STAY 중 하나를 반환해야 한다.") {
        // given
        val car = Car(1)

        // when
        val moveStatus = car.move()

        // then
        moveStatus shouldBeOneOf listOf(MoveStatus.FORWARD, MoveStatus.STAY)
    }
})
