package step4

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class WinnerFinderTest : FunSpec({
    test("get() 테스트 - 우승자를 찾는다") {
        // given
        val givenForwardMoveFactor = 9
        val givenStayMoveFactor = 1
        val cars =
            listOf(
                Car.of("a") // 4번 전진
                    .also { it.move(givenForwardMoveFactor) }
                    .also { it.move(givenForwardMoveFactor) }
                    .also { it.move(givenStayMoveFactor) }
                    .also { it.move(givenForwardMoveFactor) }
                    .also { it.move(givenForwardMoveFactor) },
                Car.of("b") // 4번 전진
                    .also { it.move(givenForwardMoveFactor) }
                    .also { it.move(givenForwardMoveFactor) }
                    .also { it.move(givenForwardMoveFactor) }
                    .also { it.move(givenStayMoveFactor) }
                    .also { it.move(givenForwardMoveFactor) },
                Car.of("c") // 2번 전진
                    .also { it.move(givenForwardMoveFactor) }
                    .also { it.move(givenStayMoveFactor) }
                    .also { it.move(givenStayMoveFactor) }
                    .also { it.move(givenStayMoveFactor) }
                    .also { it.move(givenForwardMoveFactor) },
            )
        val winner = WinnerFinder.get(cars)
        winner shouldBe listOf("a", "b")
    }
})
