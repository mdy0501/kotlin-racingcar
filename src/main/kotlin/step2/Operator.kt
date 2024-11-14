package step2

internal enum class Operator(val operator: String) {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    ;

    companion object {
        fun from(operator: String): Operator {
            return when (operator) {
                "+" -> ADD
                "-" -> SUBTRACT
                "*" -> MULTIPLY
                "/" -> DIVIDE
                else -> throw IllegalArgumentException("지원하지 않는 연산자입니다.")
            }
        }
    }
}
