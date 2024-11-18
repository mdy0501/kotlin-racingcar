package step3

import kotlin.random.Random

object RandomGenerator {
    fun generate(): Int {
        return Random.nextInt(0, 10) // 0부터 9까지 랜덤 숫자 생성
    }
}
