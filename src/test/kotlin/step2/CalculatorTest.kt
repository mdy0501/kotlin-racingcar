package step2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : FunSpec({
    test("add() 테스트") {
        // given
        val value1 = 2L
        val value2 = 3L

        // when
        val result = Calculator.add(value1, value2)

        // then
        result shouldBe 5L
    }

    test("subtract() 테스트") {
        // given
        val value1 = 5L
        val value2 = 2L

        // when
        val result = Calculator.subtract(value1, value2)

        // then
        result shouldBe 3L
    }

    test("multiply() 테스트") {
        // given
        val value1 = 2L
        val value2 = 3L

        // when
        val result = Calculator.multiply(value1, value2)

        // then
        result shouldBe 6L
    }

    test("divide() 테스트") {
        // given
        val numerator = 6L
        val denominator = 3L

        // when
        val result = Calculator.divide(numerator, denominator)

        // then
        result shouldBe 2L
    }

    test("divide() 분모가 0인 경우, ArithmeticException이 발생한다.") {
        // given
        val numerator = 6L
        val denominator = 0L

        // when, then
        val exception =
            shouldThrow<ArithmeticException> {
                Calculator.divide(numerator, denominator)
            }
        exception.message shouldBe "0으로 나눌 수 없습니다."
    }
})
