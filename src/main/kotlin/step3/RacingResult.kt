package step3

data class RacingResult(
    val carNumber: Int,
    val moveHistories: MutableList<MoveStatus> = mutableListOf(),
) {
    fun addHistory(moveStatus: MoveStatus) {
        moveHistories.add(moveStatus)
    }

    fun getMoveHistory(n: Int): String {
        return this.moveHistories.take(n).filter { it == MoveStatus.FORWARD }.joinToString("") { it.display }
    }
}
