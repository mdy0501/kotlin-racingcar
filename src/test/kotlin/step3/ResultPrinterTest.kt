package step3

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class ResultPrinterTest : FunSpec({
    test("print() 테스트") {
        // given
        val givenRacingResults =
            listOf(
                RacingResult(1, mutableListOf(MoveStatus.FORWARD, MoveStatus.STAY, MoveStatus.FORWARD)),
                RacingResult(2, mutableListOf(MoveStatus.STAY, MoveStatus.FORWARD, MoveStatus.FORWARD)),
            )
        val givenMoveCount = 3

        val originalOut = System.out
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        try {
            // when
            ResultPrinter.print(moveCount = givenMoveCount, racingResults = givenRacingResults)

            // then
            val expectedOutput =
                """
                -
                
                
                -
                -
                
                --
                --
                """.trimIndent()

            outputStream.toString().trim() shouldBe expectedOutput
        } finally {
            // System.out 원복
            System.setOut(originalOut)
        }
    }
})
