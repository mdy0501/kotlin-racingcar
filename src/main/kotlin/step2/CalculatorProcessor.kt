package step2

internal class CalculatorProcessor {
    fun process(input: String): Long {
        // validation
        InputValidator.validate(input)

        val iterator = input.split(" ").listIterator()
        // 첫 번째 숫자를 초기값으로 설정
        var result = iterator.next().toLong()

        // iterator 로 연산자와 값을 순차적으로 가져와 계산
        while (iterator.hasNext()) {
            val operator = Operator.from(iterator.next())
            val value = iterator.next().toLong()

            result =
                when (operator) {
                    Operator.ADD -> Calculator.add(value1 = result, value2 = value)
                    Operator.SUBTRACT -> Calculator.subtract(value1 = result, value2 = value)
                    Operator.MULTIPLY -> Calculator.multiply(value1 = result, value2 = value)
                    Operator.DIVIDE -> Calculator.divide(numerator = result, denominator = value)
                }
        }
        return result
    }
}
