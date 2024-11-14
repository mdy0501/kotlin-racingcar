package step2

internal object Calculator {
    fun add(
        value1: Long,
        value2: Long,
    ): Long {
        return value1 + value2
    }

    fun subtract(
        value1: Long,
        value2: Long,
    ): Long {
        return value1 - value2
    }

    fun multiply(
        value1: Long,
        value2: Long,
    ): Long {
        return value1 * value2
    }

    /**
     * @throws ArithmeticException 분모가 0인 경우
     */
    fun divide(
        numerator: Long,
        denominator: Long,
    ): Long {
        if (denominator == 0L) {
            throw ArithmeticException("0으로 나눌 수 없습니다.")
        }
        return numerator / denominator
    }
}
