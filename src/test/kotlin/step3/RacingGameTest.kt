package step3

import io.kotest.core.spec.style.FunSpec
import io.mockk.every
import io.mockk.justRun
import io.mockk.mockkConstructor
import io.mockk.verify

class RacingGameTest : FunSpec({
    test("execute()는 RacingGame의 모든 단계를 호출한다.") {
        // given
        val givenCarCount = 2
        val givenMoveCount = 3

        // CarGenerator 생성자 Mock
        mockkConstructor(CarGenerator::class)
        val mockCars = listOf(Car(1), Car(2))
        every { anyConstructed<CarGenerator>().generate(count = givenCarCount) } returns mockCars

        // RacingProcessor 생성자 Mock
        mockkConstructor(RacingProcessor::class)
        val mockRacingResults =
            listOf(
                RacingResult(1, mutableListOf(MoveStatus.FORWARD, MoveStatus.STAY)),
                RacingResult(2, mutableListOf(MoveStatus.STAY, MoveStatus.FORWARD)),
            )
        every { anyConstructed<RacingProcessor>().race(moveCount = givenMoveCount) } returns mockRacingResults

        // ResultPrinter Mock
        mockkConstructor(ResultPrinter::class)
        justRun { ResultPrinter.print(moveCount = givenMoveCount, racingResults = mockRacingResults) }

        // when
        RacingGame().execute(carCount = givenCarCount, moveCount = givenMoveCount)

        // then
        verify(exactly = 1) { anyConstructed<CarGenerator>().generate(count = givenCarCount) } // CarGenerator 호출 검증
        verify(exactly = 1) { anyConstructed<RacingProcessor>().race(moveCount = givenMoveCount) } // RacingProcessor 호출 검증
        verify(exactly = 1) {
            ResultPrinter.print(
                moveCount = givenMoveCount,
                racingResults = mockRacingResults,
            )
        } // ResultPrinter 호출 검증
    }
})
