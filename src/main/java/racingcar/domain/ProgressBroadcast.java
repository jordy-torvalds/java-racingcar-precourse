package racingcar.domain;

import static java.lang.String.format;

public class ProgressBroadcast {

    private ProgressBroadcast() {
    }

    private static StringBuilder raceProgress = new StringBuilder();

    public static String createRaceProgressString(RacingCars racingCars) {
        initializeRaceProgress();
        for (int i = 0; i < racingCars.getSize(); i++) {
            RacingCar racingCar = racingCars.getRacingCarBySpecificIndex(i);
            Position position = racingCar.getPosition();
            String positionPrint = PositionPrintCache.getPositionPrint(position.getValue());
            raceProgress.append(format("%s:%s\n", racingCar.getName(), positionPrint));
        }
        raceProgress.append("\n");
        return raceProgress.toString();
    }

    private static void initializeRaceProgress() {
        raceProgress.setLength(0);
    }
}
