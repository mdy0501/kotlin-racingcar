package step2

class CalculatorProcessor {
    fun process(input: String): Long {
        // validation
        InputValidator.validate(input)

        val tokens = input.split(" ")
        val initialValue = tokens.first().toLong() // 첫 번째 숫자를 초기값으로 분리

        return tokens.drop(1)
            .chunked(2)
            .fold(initialValue) { acc, (operator, value) ->
                val op = Operator.from(operator)
                op.execute(acc, value.toLong())
            }
    }
}
