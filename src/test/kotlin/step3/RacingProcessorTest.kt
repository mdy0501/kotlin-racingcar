package step3

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.unmockkAll

class RacingProcessorTest : FunSpec({
    beforeTest {
        unmockkAll() // 모든 Mock 객체 및 설정 초기화
    }
    test("race()는 각 자동차의 이동 상태를 moveCount만큼 RacingResult에 저장한다") {
        // given
        val givenCar1 =
            mockk<Car> {
                every { number } returns 1
                every { move() } returns MoveStatus.FORWARD
            }
        val givenCar2 =
            mockk<Car> {
                every { number } returns 2
                every { move() } returns MoveStatus.STAY
            }
        val givenMoveCount = 3

        // when
        val result = RacingProcessor(cars = listOf(givenCar1, givenCar2)).race(moveCount = givenMoveCount)

        // then
        result shouldHaveSize 2 // 두 대의 자동차 결과가 존재
        result[0].carNumber shouldBe 1 // 첫 번째 자동차의 번호 확인
        result[1].carNumber shouldBe 2 // 두 번째 자동차의 번호 확인

        // 첫 번째 자동차의 이동 기록 확인
        result[0].moveHistories shouldBe listOf(MoveStatus.FORWARD, MoveStatus.FORWARD, MoveStatus.FORWARD)
        // 두 번째 자동차의 이동 기록 확인
        result[1].moveHistories shouldBe listOf(MoveStatus.STAY, MoveStatus.STAY, MoveStatus.STAY)
    }
})
