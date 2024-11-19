package step4

import step4.domain.RandomGenerator

class FixedRandomGenerator(private val fixedValue: Int) : RandomGenerator {
    override fun generate(): Int {
        return fixedValue
    }
}
