package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RaceWinnerJudge {

    private RaceWinnerJudge() {
    }

    private static List<String> winners = new ArrayList<>();

    public static String getRaceWinner(RacingCars racingCars) {
       int highestKey = PositionCache.getHighestKey();

        for (int i = 0; i < racingCars.getSize(); i++) {
            addWinningCarNameOnly(racingCars.getRacingCarBySpecificIndex(i), highestKey);
        }

        return String.join(",",winners);
    }

    public static void clearWinners() {
        winners.clear();
    }

    private static void addWinningCarNameOnly(RacingCar racingCar, int highestPosition) {
        Position racingCarPosition = racingCar.getPosition();

        if (racingCarPosition.getValue() == highestPosition) {
            winners.add(racingCar.getName());
        }
    }
}
