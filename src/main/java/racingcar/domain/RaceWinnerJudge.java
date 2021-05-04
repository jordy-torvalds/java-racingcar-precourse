package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RaceWinnerJudge {
    private static List<String> winner = new ArrayList<>();

    public static List<String> getRaceWinner(RacingCars racingCars) {
        winner.clear();
        int highestKey = PositionCache.getHighestKey();
        for (int i = 0; i < racingCars.getSize(); i++) {
            addWinningCarNameOnly(racingCars.getRacingCarBySpecificIndex(i), highestKey);
        }

        return winner;
    }

    private static void addWinningCarNameOnly(RacingCar racingCar, int highestPosition) {
        Position racingCarPosition = racingCar.getPosition();

        if (racingCarPosition.getValue() == highestPosition) {
            winner.add(racingCar.getName());
        }
    }
}
