package step4

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CarTest : FunSpec({
    context("Car.of() 테스트") {
        test("Car.of()는 이름을 받아 Car 객체를 생성해야 한다.") {
            // given
            val givenName = "myCar"

            // when
            val car = Car.of(givenName)

            // then
            car.name shouldBe givenName
        }
        test("Car.of()는 이름을 받아 Car 객체를 생성할 때, moveHistory는 비어있어야 한다.") {
            // given
            val givenName = "myCar"

            // when
            val car = Car.of(givenName)

            // then
            car.moveHistory shouldBe emptyList()
        }
        test("car의 이름은 1자 이상, 5자 이하만 가능하다.") {
            // given
            val givenName1 = "m"
            val givenName2 = "my"
            val givenName3 = "myC"
            val givenName4 = "myCa"
            val givenName5 = "myCar"

            // when
            shouldNotThrow<IllegalStateException> {
                Car.of(givenName1)
                Car.of(givenName2)
                Car.of(givenName3)
                Car.of(givenName4)
                Car.of(givenName5)
            }
        }
        test("car의 이름이 0자 이거나 6자 이상이면 IllegalArgumentException이 발생한다.") {
            // given
            val givenName1 = ""
            val givenName2 = "myCar123456"

            // when
            shouldThrow<IllegalArgumentException> {
                Car.of(givenName1)
                Car.of(givenName2)
            }
        }
    }
    context("move() 테스트") {
        test("move()는 moveFactor가 4이상이면 FORWARD를 반환해야 한다.") {
            // given
            val givenCar = Car.of("myCar")
            val givenMoveFactor = 4

            // when
            val moveStatus = givenCar.move(moveFactor = givenMoveFactor)

            // then
            moveStatus shouldBe MoveStatus.FORWARD
            givenCar.moveHistory shouldBe listOf(MoveStatus.FORWARD)
        }

        test("move()는 moveFactor가 3이하면 STAY를 반환해야 한다.") {
            // given
            val givenCar = Car.of("myCar")
            val givenMoveFactor = 3

            // when
            val moveStatus = givenCar.move(moveFactor = givenMoveFactor)

            // then
            moveStatus shouldBe MoveStatus.STAY
            givenCar.moveHistory shouldBe listOf(MoveStatus.STAY)
        }
    }

    context("getForwardMoveCount() 테스트") {
        test("getForwardMoveCount()는 4번의 전진 기록이 있을 때, 그 기록의 개수 4를 반환해야 한다.") {
            // given
            val givenForwardMoveFactor = 9
            val givenCar =
                Car.of("myCar")
                    .also { it.move(givenForwardMoveFactor) }
                    .also { it.move(givenForwardMoveFactor) }
                    .also { it.move(givenForwardMoveFactor) }
                    .also { it.move(givenForwardMoveFactor) }

            // when
            val forwardMoveCount = givenCar.getForwardMoveCount()

            // then
            forwardMoveCount shouldBe 4
        }
    }

    context("getForwardMoveHistory() 테스트") {
        test("getForwardMoveHistory()는 4번의 전진 기록이 있을 때, 그 기록을 `----`으로 반환해야 한다.") {
            // given
            val givenForwardMoveFactor = 9
            val givenCar =
                Car.of("myCar")
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
                Car.of("myCar")
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
