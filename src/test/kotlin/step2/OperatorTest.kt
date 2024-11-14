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
})
