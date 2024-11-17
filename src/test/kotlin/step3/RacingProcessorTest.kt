package step3

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

class RacingProcessorTest : FunSpec({
    test("race()는 모든 자동차가 moveCount만큼 이동 기록을 남겨야 한다.") {
        // given
        val moveCount = 3
        val cars = listOf(Car(1), Car(2), Car(3))
        val givenForwardMoveFactor = 9

        // when
        repeat(moveCount) {
            cars.forEach { car ->
                car.move(moveFactor = givenForwardMoveFactor)
            }
        }

        // then
        cars.forEach { car ->
            car.moveHistory.shouldHaveSize(moveCount) // 각 자동차의 이동 기록 개수 검증
        }
        cars[0].moveHistory[0] shouldBe MoveStatus.FORWARD
        cars[0].moveHistory[1] shouldBe MoveStatus.FORWARD
        cars[0].moveHistory[2] shouldBe MoveStatus.FORWARD
    }
})
