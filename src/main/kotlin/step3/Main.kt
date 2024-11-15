package step3

fun main() {
    println("자동차 대수는 몇 대인가요?")
    val carCount = readlnOrNull()?.toInt()
    println("시도할 횟수는 몇 회인가요?")
    val moveCount = readlnOrNull()?.toInt()
    RacingGame().execute(carCount!!, moveCount!!)
}
