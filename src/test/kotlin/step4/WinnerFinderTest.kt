package step4

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import step4.domain.WinnerFinder

class WinnerFinderTest : FunSpec({
    test("get() 테스트 - 우승자를 찾는다") {
        // given
        val cars =
            listOf(
                // 4번 전진 & 1번 정지
                CarStub.get(name = "a", forwordMoveCount = 4, stayMoveCount = 1),
                // 4번 전진 & 1번 정지
                CarStub.get(name = "b", forwordMoveCount = 4, stayMoveCount = 1),
                // 2번 전진 & 3번 정지
                CarStub.get(name = "c", forwordMoveCount = 2, stayMoveCount = 3),
            )
        val winner = WinnerFinder.get(cars)
        winner shouldBe listOf("a", "b")
    }
})
