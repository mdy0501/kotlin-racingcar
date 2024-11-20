package step4

import step4.domain.DefaultRandomGenerator
import step4.domain.RacingGame
import step4.domain.WinnerFinder
import step4.view.InputView
import step4.view.OutputView

class RacingApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val carNames = InputView.getCarNames()
            val moveCount = InputView.getMoveCount()
            println()
            val completedCars = RacingGame(DefaultRandomGenerator()).execute(carNames, moveCount)
            OutputView.printRacingResult(moveCount, completedCars)
            val winners = WinnerFinder.get(completedCars)
            OutputView.printWinners(winners = winners)
        }
    }
}
