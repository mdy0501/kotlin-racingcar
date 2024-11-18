package step3

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CarTest : FunSpec({
    context("move() 테스트") {
        test("move()는 moveFactor가 4이상이면 FORWARD를 반환해야 한다.") {
            // given
            val givenCar = Car(1)
            val givenMoveFactor = 4

            // when
            val moveStatus = givenCar.move(moveFactor = givenMoveFactor)

            // then
            moveStatus shouldBe MoveStatus.FORWARD
            givenCar.moveHistory shouldBe listOf(MoveStatus.FORWARD)
        }

        test("move()는 moveFactor가 3이하면 STAY를 반환해야 한다.") {
            // given
            val givenCar = Car(1)
            val givenMoveFactor = 3

            // when
            val moveStatus = givenCar.move(moveFactor = givenMoveFactor)

            // then
            moveStatus shouldBe MoveStatus.STAY
            givenCar.moveHistory shouldBe listOf(MoveStatus.STAY)
        }
    }
    context("getForwardMoveHistory() 테스트") {
        test("getForwardMoveHistory()는 4번의 전진 기록이 있을 때, 그 기록을 `----`으로 반환해야 한다.") {
            // given
            val givenForwardMoveFactor = 9
            val givenCar =
                Car(1)
                    .also { it.move(givenForwardMoveFactor) }
                    .also { it.move(givenForwardMoveFactor) }
                    .also { it.move(givenForwardMoveFactor) }
                    .also { it.move(givenForwardMoveFactor) }

            // when
            val forwardMoveHistory = givenCar.getForwardMoveHistory(4)

            // then
            forwardMoveHistory shouldBe "----"
        }

        test("getForwardMoveHistory()는 전진 기록이 없을때, 그 기록을 빈문자열(``)로 반환해야 한다.") {
            // given
            val givenStayMoveFactor = 1
            val givenCar =
                Car(1)
                    .also { it.move(givenStayMoveFactor) }
                    .also { it.move(givenStayMoveFactor) }
                    .also { it.move(givenStayMoveFactor) }
                    .also { it.move(givenStayMoveFactor) }

            // when
            val forwardMoveHistory = givenCar.getForwardMoveHistory(4)

            // then
            forwardMoveHistory shouldBe ""
        }
    }
})
