package step2

enum class Operator(val operator: String) {
    ADD("+") {
        override fun execute(
            left: Long,
            right: Long,
        ): Long = left + right
    },
    SUBTRACT("-") {
        override fun execute(
            left: Long,
            right: Long,
        ): Long = left - right
    },
    MULTIPLY("*") {
        override fun execute(
            left: Long,
            right: Long,
        ): Long = left * right
    },
    DIVIDE("/") {
        override fun execute(
            left: Long,
            right: Long,
        ): Long {
            if (right == 0L) {
                throw ArithmeticException("0으로 나눌 수 없습니다.")
            }
            return left / right
        }
    },
    ;

    abstract fun execute(
        left: Long,
        right: Long,
    ): Long

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
