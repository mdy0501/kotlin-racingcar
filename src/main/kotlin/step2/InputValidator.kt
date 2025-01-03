package step2

object InputValidator {
    fun validate(input: String) {
        require(input.isNotBlank()) { "빈 값이 입력되었습니다. [input: $input]" }
        require(this.hasLeadingOrTrailingSpaces(input).not()) { "앞 뒤 공백은 허용되지 않습니다. [input: $input]" }
        require(this.hasInvalidOperator(input).not()) { "연산자의 위치에 적절하지 않은 문자가 포함되어 있습니다. [input: $input]" }
        require(this.hasInvalidNumber(input).not()) { "숫자의 위치에 숫자가 아닌 값이 포함되어 있습니다. [input: $input]" }
    }

    private fun hasLeadingOrTrailingSpaces(input: String): Boolean {
        return input.startsWith(" ") || input.endsWith(" ")
    }

    private fun hasInvalidOperator(input: String): Boolean {
        val operators = input.split(" ").filterIndexed { index, _ -> index % 2 == 1 }
        operators.forEach { a ->
            if (Operator.entries.map { it.operator }.contains(a).not()) {
                return true
            }
        }
        return false
    }

    private fun hasInvalidNumber(input: String): Boolean {
        val numbers = input.split(" ").filterIndexed { index, _ -> index % 2 == 0 }
        numbers.forEach { a ->
            if (a.toLongOrNull() == null) {
                return true
            }
        }
        return false
    }
}
