package step4

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

class RacingProcessorTest : FunSpec({
    test("race()는 모든 자동차가 moveCount만큼 이동 기록을 남겨야 한다.") {
        // given
        val givenMoveCount = 3
        val givenCars = listOf(Car.of("car1"), Car.of("car2"), Car.of("car3"))
        val givenForwardMoveFactor = 9

        // when
        repeat(givenMoveCount) {
            givenCars.forEach { car ->
                car.move(moveFactor = givenForwardMoveFactor)
            }
        }

        // then
        givenCars.forEach { car ->
            car.moveHistory.shouldHaveSize(givenMoveCount) // 각 자동차의 이동 기록 개수 검증
        }
        givenCars[0].moveHistory[0] shouldBe MoveStatus.FORWARD
        givenCars[0].moveHistory[1] shouldBe MoveStatus.FORWARD
        givenCars[0].moveHistory[2] shouldBe MoveStatus.FORWARD
    }
})
