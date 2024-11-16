package step2

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class OperatorTest : FunSpec({
    test("from() 메서드 테스트") {
        // given
        val operator1 = "+"
        val operator2 = "-"
        val operator3 = "*"
        val operator4 = "/"

        // when
        val result1 = Operator.from(operator1)
        val result2 = Operator.from(operator2)
        val result3 = Operator.from(operator3)
        val result4 = Operator.from(operator4)

        // then
        result1 shouldBe Operator.ADD
        result2 shouldBe Operator.SUBTRACT
        result3 shouldBe Operator.MULTIPLY
        result4 shouldBe Operator.DIVIDE
    }

    test("execute() 메서드 테스트") {
        // given
        val left = 10L
        val right = 5L

        // when
        val result1 = Operator.ADD.execute(left, right)
        val result2 = Operator.SUBTRACT.execute(left, right)
        val result3 = Operator.MULTIPLY.execute(left, right)
        val result4 = Operator.DIVIDE.execute(left, right)

        // then
        result1 shouldBe 15
        result2 shouldBe 5
        result3 shouldBe 50
        result4 shouldBe 2
    }
})
