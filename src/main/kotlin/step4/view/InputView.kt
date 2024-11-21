package step4.view

object InputView {
    fun getCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val input = readlnOrNull() ?: throw IllegalArgumentException("자동차 이름 입력은 필수입니다.")
        return input.split(",").map { it.trim() }
    }

    fun getMoveCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readlnOrNull()?.toIntOrNull() ?: throw IllegalArgumentException("올바른 시도 횟수를 입력해주세요.")
    }
}
