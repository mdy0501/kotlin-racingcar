
package step2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CalculatorProcessorTest : FunSpec({
    val calculatorProcessor = CalculatorProcessor()

    context("process() 테스트") {
        context("정상 케이스") {
            test("숫자가 2개, 연산자가 1개인 경우, 정상적으로 계산이 된다.") {
                // given
                val givenInput = "2 + 3"

                // when
                val result = calculatorProcessor.process(givenInput)

                // then
                result shouldBe 5
            }
            test("숫자가 3개, 연산자가 2개인 경우, 정상적으로 계산이 된다.") {
                // given
                val givenInput = "2 + 3 * 4"

                // when
                val result = calculatorProcessor.process(givenInput)

                // then
                result shouldBe 20
            }
            test("숫자가 4개, 연산자가 3개인 경우, 정상적으로 계산이 된다.") {
                // given
                val givenInput = "2 + 3 * 4 / 2"

                // when
                val result = calculatorProcessor.process(givenInput)

                // then
                result shouldBe 10
            }
            test("(사칙연산을 모두 포함하는 경우) 숫자가 5개, 연산자가 4개인 경우, 정상적으로 계산이 된다.") {
                // given
                val givenInput = "2 + 3 * 4 / 2 - 1"

                // when
                val result = calculatorProcessor.process(givenInput)

                // then
                result shouldBe 9
            }
        }
        context("실패 케이스") {
            test("빈 문자열을 입력하는 경우, IllegalArgumentException이 발생한다.") {
                // given
                val givenInput = ""

                // when, then
                val exception =
                    shouldThrow<IllegalArgumentException> {
                        calculatorProcessor.process(givenInput)
                    }
                exception.message shouldBe "빈 값이 입력되었습니다."
            }

            test("입력 문자열이 앞에 공백을 포함하는 경우, IllegalArgumentException이 발생한다.") {
                // given
                val givenInput = " 2 + 3"

                // when, then
                val exception =
                    shouldThrow<IllegalArgumentException> {
                        calculatorProcessor.process(givenInput)
                    }
                exception.message shouldBe "앞 뒤 공백은 허용되지 않습니다."
            }

            test("입력 문자열이 뒤에 공백을 포함하는 경우, IllegalArgumentException이 발생한다.") {
                // given
                val givenInput = "2 + 3 "

                // when, then
                val exception =
                    shouldThrow<IllegalArgumentException> {
                        calculatorProcessor.process(givenInput)
                    }
                exception.message shouldBe "앞 뒤 공백은 허용되지 않습니다."
            }

            test("입력 문자열의 연산자 위치에 지원하지 않는 연산자가 포함되면, IllegalArgumentException이 발생한다.") {
                // given
                val givenInput = "2 + 3 ^ 4"

                // when, then
                val exception =
                    shouldThrow<IllegalArgumentException> {
                        calculatorProcessor.process(givenInput)
                    }
                exception.message shouldBe "연산자의 위치에 적절하지 않은 문자가 포함되어 있습니다."
            }

            test("입력 문자열의 연산자 위치에 숫자가 포함되어있으면, IllegalArgumentException이 발생한다.") {
                // given
                val givenInput = "2 3 + 4"

                // when, then
                val exception =
                    shouldThrow<IllegalArgumentException> {
                        calculatorProcessor.process(givenInput)
                    }
                exception.message shouldBe "연산자의 위치에 적절하지 않은 문자가 포함되어 있습니다."
            }

            test("입력 문자열의 숫자 위치에 숫자가 아닌 값이 포함되면, IllegalArgumentException이 발생한다.") {
                // given
                val givenInput = "2 + 3 * a"

                // when, then
                val exception =
                    shouldThrow<IllegalArgumentException> {
                        calculatorProcessor.process(givenInput)
                    }
                exception.message shouldBe "숫자의 위치에 숫자가 아닌 값이 포함되어 있습니다."
            }
        }
    }
})
