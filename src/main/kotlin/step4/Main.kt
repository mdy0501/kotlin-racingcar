package step4

fun main() {
    println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
    val carNames = readlnOrNull()?.split(",")
    println("시도할 횟수는 몇 회인가요?")
    val moveCount = readlnOrNull()?.toInt()
    println()
    RacingGame().execute(carNames!!, moveCount!!)
}
