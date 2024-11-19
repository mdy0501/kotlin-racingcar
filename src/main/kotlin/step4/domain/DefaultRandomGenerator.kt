package step4.domain

import kotlin.random.Random

class DefaultRandomGenerator : RandomGenerator {
    override fun generate(): Int {
        return Random.nextInt(10) // 0부터 9까지 랜덤 숫자 생성
    }
}
