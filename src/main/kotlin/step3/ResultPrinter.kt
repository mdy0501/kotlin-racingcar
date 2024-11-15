package step3

object ResultPrinter {
    fun print(
        moveCount: Int,
        racingResults: List<RacingResult>,
    ) {
        repeat(moveCount) { i ->
            racingResults.forEach { result ->
                println(result.getMoveHistory(i + 1))
            }
            println()
        }
    }
}
