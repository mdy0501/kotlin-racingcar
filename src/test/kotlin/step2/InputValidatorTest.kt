package step2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class InputValidatorTest : FunSpec({
    context("validate() 테스트") {
        test("빈 문자열을 입력하는 경우, IllegalArgumentException이 발생한다.") {
            // given
            val givenInput = ""

            // when, then
            val exception =
                shouldThrow<IllegalArgumentException> {
                    InputValidator.validate(givenInput)
                }
            exception.message shouldBe "빈 값이 입력되었습니다. [input: $givenInput]"
        }

        test("앞에 공백이 있는 문자열을 입력하는 경우, IllegalArgumentException이 발생한다.") {
            // given
            val givenInput = " 2 + 3"

            // when, then
            val exception =
                shouldThrow<IllegalArgumentException> {
                    InputValidator.validate(givenInput)
                }
            exception.message shouldBe "앞 뒤 공백은 허용되지 않습니다. [input: $givenInput]"
        }

        test("뒤에 공백이 있는 문자열을 입력하는 경우, IllegalArgumentException이 발생한다.") {
            // given
            val givenInput = "2 + 3 "

            // when, then
            val exception =
                shouldThrow<IllegalArgumentException> {
                    InputValidator.validate(givenInput)
                }
            exception.message shouldBe "앞 뒤 공백은 허용되지 않습니다. [input: $givenInput]"
        }

        test("연산자의 위치에 적절하지 않은 문자가 포함되어 있는 경우, IllegalArgumentException이 발생한다.") {
            // given
            val givenInput = "2 + 3 a 5"

            // when, then
            val exception =
                shouldThrow<IllegalArgumentException> {
                    InputValidator.validate(givenInput)
                }
            exception.message shouldBe "연산자의 위치에 적절하지 않은 문자가 포함되어 있습니다. [input: $givenInput]"
        }

        test("숫자의 위치에 숫자가 아닌 값이 포함되어 있는 경우, IllegalArgumentException이 발생한다.") {
            // given
            val givenInput = "2 + a * 5"

            // when, then
            val exception =
                shouldThrow<IllegalArgumentException> {
                    InputValidator.validate(givenInput)
                }
            exception.message shouldBe "숫자의 위치에 숫자가 아닌 값이 포함되어 있습니다. [input: $givenInput]"
        }
    }
})
