package step4.domain

class Car private constructor(
    val name: String,
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

    private fun addHistory(moveStatus: MoveStatus) {
        _moveHistory.add(moveStatus)
    }

    fun getForwardMoveCount(): Int {
        return this.moveHistory.filter { it == MoveStatus.FORWARD }.size
    }

    fun getForwardMoveHistory(n: Int): List<MoveStatus> {
        return this.moveHistory.take(n).filter { it == MoveStatus.FORWARD }
    }

    companion object {
        fun of(name: String): Car {
            require(name.length in 1..5) { "자동차 이름은 1자 이상, 5자 이하만 가능합니다. [name: $name]" }
            return Car(name)
        }

        const val FORWARD_MOVE_FACTOR = 4
    }
}
