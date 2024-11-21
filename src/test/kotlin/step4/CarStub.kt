package step4

import step4.domain.Car

object CarStub {
    fun get(
        name: String = "name",
        forwordMoveCount: Int = 0,
        stayMoveCount: Int = 0,
    ): Car {
        return Car.of(name = name)
            .apply { repeat(forwordMoveCount) { move(FORWARD_MOVE_FACTOR) } }
            .apply { repeat(stayMoveCount) { move(STAY_MOVE_FACTOR) } }
    }

    private const val FORWARD_MOVE_FACTOR = 9
    private const val STAY_MOVE_FACTOR = 1
}
