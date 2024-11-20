package step4.domain

class DefaultRandomGenerator : RandomGenerator {
    override fun generate(): Int {
        return (0..9).random() // 0부터 9까지 랜덤 숫자 생성
    }
}
