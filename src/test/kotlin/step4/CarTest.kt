package step4

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.matchers.shouldBe
import step4.domain.Car
import step4.domain.MoveStatus

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
            val testCases =
                table(
                    headers("input", "expected"),
                    row("m", true),
                    row("my", true),
                    row("myC", true),
                    row("myCa", true),
                    row("myCar", true),
                )

            // when
            forAll(testCases) { input, expected ->
                if (expected) {
                    shouldNotThrow<IllegalStateException> {
                        Car.of(input)
                    }
                } else {
                    shouldThrow<IllegalArgumentException> {
                        Car.of(input)
                    }
                }
            }
        }
        test("car의 이름이 0자 이거나 6자 이상이면 IllegalArgumentException이 발생한다.") {
            // given
            val testCases =
                table(
                    headers("input"),
                    row(""),
                    row("myCar123456"),
                )

            // when
            forAll(testCases) { input ->
                shouldThrow<IllegalArgumentException> {
                    Car.of(input)
                }
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
            val givenCar = CarStub.get(forwordMoveCount = 4)

            // when
            val forwardMoveCount = givenCar.getForwardMoveCount()

            // then
            forwardMoveCount shouldBe 4
        }
    }

    context("getForwardMoveHistory() 테스트") {
        test("getForwardMoveHistory()는 4번의 전진 기록이 있을 때, size가 4이고, 모두 FORWARD인 List<MoveStatus>를 리턴한다.") {
            // given
            val givenForwardMoveCount = 4
            val givenCar = CarStub.get(forwordMoveCount = givenForwardMoveCount)

            // when
            val forwardMoveHistory = givenCar.getForwardMoveHistory(4)

            // then
            forwardMoveHistory.size shouldBe 4
            forwardMoveHistory.all { it == MoveStatus.FORWARD } shouldBe true
        }

        test("getForwardMoveHistory()는 5번의 정지 기록만 있을 때, size가 0인 List<MoveStatus>를 리턴한다.") {
            // given
            val givenForwardMoveCount = 0
            val givenStayMoveCount = 5
            val givenCar = CarStub.get(forwordMoveCount = givenForwardMoveCount, stayMoveCount = givenStayMoveCount)

            // when
            val forwardMoveHistory = givenCar.getForwardMoveHistory(5)

            // then
            forwardMoveHistory.size shouldBe 0
        }
    }
})
