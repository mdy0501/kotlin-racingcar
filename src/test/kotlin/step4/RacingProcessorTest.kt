package step4

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import step4.domain.Car
import step4.domain.MoveStatus
import step4.domain.RacingProcessor

class RacingProcessorTest : FunSpec({
    test("모든 자동차가 주어진 moveCount 만큼 FORWARD_MOVE_FACTOR 조건을 만족했을 때 전진해야 한다.") {
        // given
        val givenMoveCount = 3
        val givenCars = listOf(Car.of("car1"), Car.of("car2"), Car.of("car3"))
        val givenForwardMoveFactor = 9 // 항상 FORWARD_MOVE_FACTOR(4) 이상 값을 생성
        val randomGenerator = FixedRandomGenerator(givenForwardMoveFactor)

        // when
        val res =
            RacingProcessor(randomGenerator).race(
                moveCount = givenMoveCount,
                cars = givenCars,
            )

        // then
        res.forEach { car ->
            car.getForwardMoveCount() shouldBe givenMoveCount // 각 자동차가 모든 이동에서 전진했는지 확인
            car.moveHistory.all { it == MoveStatus.FORWARD } shouldBe true // 이동 이력이 모두 FORWARD인지 확인
        }
    }

    test("모든 자동차가 주어진 moveCount 만큼 FORWARD_MOVE_FACTOR 조건을 만족하지 않을 때 정지해야 한다.") {
        // given
        val givenMoveCount = 3
        val givenCars = listOf(Car.of("car1"), Car.of("car2"), Car.of("car3"))
        val givenStayMoveFactor = 1 // 항상 FORWARD_MOVE_FACTOR(4) 미만 값을 생성
        val randomGenerator = FixedRandomGenerator(givenStayMoveFactor)

        // when
        val res =
            RacingProcessor(randomGenerator).race(
                moveCount = givenMoveCount,
                cars = givenCars,
            )

        // then
        res.forEach { car ->
            car.getForwardMoveCount() shouldBe 0 // 각 자동차가 전진하지 않았는지 확인
            car.moveHistory.all { it == MoveStatus.STAY } shouldBe true // 이동 이력이 모두 STAY인지 확인
        }
    }
})
