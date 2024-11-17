package step3

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class ResultPrinterTest : FunSpec({
    test("print() 테스트") {
        // given
        val givenCars =
            listOf(
                Car(1)
                    .also { it.move(moveFactor = FORWARD_MOVE_FACTOR) }
                    .also { it.move(moveFactor = STAY_MOVE_FACTOR) }
                    .also { it.move(moveFactor = FORWARD_MOVE_FACTOR) },
                Car(2)
                    .also { it.move(moveFactor = STAY_MOVE_FACTOR) }
                    .also { it.move(moveFactor = FORWARD_MOVE_FACTOR) }
                    .also { it.move(moveFactor = FORWARD_MOVE_FACTOR) },
            )
        val givenMoveCount = 3

        val originalOut = System.out
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        try {
            // when
            ResultPrinter.print(moveCount = givenMoveCount, cars = givenCars)

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
}) {
    companion object {
        const val FORWARD_MOVE_FACTOR = 9
        const val STAY_MOVE_FACTOR = 1
    }
}
