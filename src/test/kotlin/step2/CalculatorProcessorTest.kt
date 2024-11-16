package step2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.matchers.shouldBe

class CalculatorProcessorTest : FunSpec({
    val calculatorProcessor = CalculatorProcessor()

    context("process() 테스트") {
        context("정상 케이스") {
            test("여러 입력값을 검증한다.") {
                val testCases =
                    table(
                        headers("input", "expected"),
                        row("2", 2L),
                        row("2 + 3", 5L),
                        row("2 + 3 * 4", 20L),
                        row("2 + 3 * 4 / 2", 10L),
                        row("2 + 3 * 4 / 2 - 1", 9L),
                    )

                forAll(testCases) { input, expected ->
                    calculatorProcessor.process(input) shouldBe expected
                }
            }
        }

        context("실패 케이스") {
            test("여러 잘못된 입력값을 검증한다.") {
                val testCases =
                    table(
                        headers("input", "expectedMessage"),
                        row("", "빈 값이 입력되었습니다. [input: ]"),
                        row(" 2 + 3", "앞 뒤 공백은 허용되지 않습니다. [input:  2 + 3]"),
                        row("2 + 3 ", "앞 뒤 공백은 허용되지 않습니다. [input: 2 + 3 ]"),
                        row("2 + 3 ^ 4", "연산자의 위치에 적절하지 않은 문자가 포함되어 있습니다. [input: 2 + 3 ^ 4]"),
                        row("2 3 + 4", "연산자의 위치에 적절하지 않은 문자가 포함되어 있습니다. [input: 2 3 + 4]"),
                        row("2 + 3 * a", "숫자의 위치에 숫자가 아닌 값이 포함되어 있습니다. [input: 2 + 3 * a]"),
                    )

                forAll(testCases) { input, expectedMessage ->
                    val exception =
                        shouldThrow<IllegalArgumentException> {
                            calculatorProcessor.process(input)
                        }
                    exception.message shouldBe expectedMessage
                }
            }
        }
    }
})
