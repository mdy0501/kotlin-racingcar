package step3

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class RacingResultTest : FunSpec({
    test("addHistory() 테스트") {
        // given
        val givenCar = Car(1)
        val givenMoveStatus = MoveStatus.FORWARD
        val givenRacingResult = RacingResult(carNumber = givenCar.number)

        // when
        givenRacingResult.addHistory(moveStatus = givenMoveStatus)

        // then
        givenRacingResult.moveHistories.size shouldBe 1
    }

    test("getMoveHistory() 테스트") {
        // given
        val givenCar = Car(1)
        val givenRacingResult = RacingResult(carNumber = givenCar.number)
        // 2번 전진 & 1번 정지
        givenRacingResult.addHistory(moveStatus = MoveStatus.FORWARD)
        givenRacingResult.addHistory(moveStatus = MoveStatus.FORWARD)
        givenRacingResult.addHistory(moveStatus = MoveStatus.STAY)

        // when
        val actual = givenRacingResult.getMoveHistory(n = 3)

        // then
        actual shouldNotBe "---"
        actual shouldBe "--"
    }
})
