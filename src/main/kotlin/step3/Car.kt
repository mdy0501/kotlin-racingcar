package step3

data class Car(
    val number: Int,
) {
    // 방어적 복사를 적용한 내부 mutable 리스트
    private val _moveHistory = mutableListOf<MoveStatus>()

    // 외부에 불변 리스트로 노출
    val moveHistory: List<MoveStatus>
        get() = _moveHistory.toList()

    fun move(moveFactor: Int): MoveStatus {
        val moveStatus = if (moveFactor >= FORWARD_MOVE_FACTOR) MoveStatus.FORWARD else MoveStatus.STAY
        this.addHistory(moveStatus)
        return moveStatus
    }

    private fun addHistory(moveStatus: MoveStatus): Car {
        _moveHistory.add(moveStatus)
        return this
    }

    fun getForwardMoveHistory(n: Int): String {
        return this.moveHistory.take(n).filter { it == MoveStatus.FORWARD }.joinToString("") { it.display }
    }

    companion object {
        const val FORWARD_MOVE_FACTOR = 4
    }
}
