package step4

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import step4.domain.Car
import step4.domain.RacingGame

class RacingGameTest : FunSpec({
    test("자동차 이름과 이동 횟수를 입력받아 레이스를 실행하고 결과를 반환한다.") {
        // given
        val carNames = listOf("car1", "car2", "car3")
        val moveCount = 3
        val forwardMoveFactor = 5 // FORWARD_MOVE_FACTOR(4) 이상 값
        val randomGenerator = FixedRandomGenerator(forwardMoveFactor)
        val racingGame = RacingGame(randomGenerator)

        // when
        val completedCars: List<Car> = racingGame.execute(carNames = carNames, moveCount = moveCount)

        // then
        completedCars.size shouldBe carNames.size // 자동차 개수가 동일한지 확인
        completedCars.map { it.name } shouldBe carNames // 자동차 이름이 동일한지 확인

        // 모든 자동차가 moveCount만큼 전진했는지 확인
        completedCars.forEach { car ->
            car.getForwardMoveCount() shouldBe moveCount
        }
    }

    test("자동차가 이동하지 않을 조건에서 레이스가 실행된다.") {
        // given
        val carNames = listOf("car1", "car2", "car3")
        val moveCount = 3
        val stayMoveFactor = 2 // FORWARD_MOVE_FACTOR(4) 미만 값
        val randomGenerator = FixedRandomGenerator(stayMoveFactor)
        val racingGame = RacingGame(randomGenerator)

        // when
        val completedCars: List<Car> = racingGame.execute(carNames = carNames, moveCount = moveCount)

        // then
        completedCars.size shouldBe carNames.size // 자동차 개수가 동일한지 확인
        completedCars.map { it.name } shouldBe carNames // 자동차 이름이 동일한지 확인

        // 모든 자동차가 이동하지 않았는지 확인
        completedCars.forEach { car ->
            car.getForwardMoveCount() shouldBe 0
        }
    }
})
