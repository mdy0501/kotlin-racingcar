package step3

import kotlin.random.Random

data class Car(
    val number: Int,
) {
    fun move(): MoveStatus {
        val randomNumber = Random.nextInt(0, 10) // 0부터 9까지 랜덤 숫자 생성
        return if (randomNumber >= 4) MoveStatus.FORWARD else MoveStatus.STAY
    }
}
