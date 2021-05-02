package racingcar.domain;

import racingcar.util.RacingCarsException;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private List<RacingCar> racingCarList = new ArrayList<>();

    public RacingCars(String racingCarsName) {
        validateRacingCarsConstructor(racingCarsName);
        createRacingCar(racingCarsName);
        GameMetaData.Position.setDefaultUsableCount(racingCarList.size());
    }

    private void processRacingCarUsingFunction(Runnable runnable) {
        runnable.run();
    }

    private int getRacingCarListSize() {
        return racingCarList.size();
    }

    private void validateRacingCarsConstructor(String racingCarsName) {
        validateRacingCarsNameLength(racingCarsName);
        validateRacingCarsSize(racingCarsName);
        validateRacingCarsNameEnd(racingCarsName);
    }

    private void validateRacingCarsNameLength(String racingCarsName) {
        if (racingCarsName.length() == 0) {
            throw new RacingCarsException.IllegalRacingCarsNameLengthException();
        }
    }

    private void validateRacingCarsSize(String racingCarsName) {
        int firstCommaIndex = racingCarsName.indexOf(",");

        if (firstCommaIndex == -1) {
            throw new RacingCarsException.IllegalRacingCarsSizeException(racingCarsName);
        }
    }

    private void validateRacingCarsNameEnd(String racingCarsName) {
        boolean isEndedComma = racingCarsName.endsWith(",");

        if (isEndedComma == true) {
            throw new RacingCarsException.IllegalRacingCarsNameEndException();
        }
    }

    private void createRacingCar(String racingCarsName) {
        String[] racingCarNameArray = racingCarsName.split(",");

        for (String racingCarName : racingCarNameArray) {
            RacingCar racingCar = new RacingCar(racingCarName);
            racingCarList.add(racingCar);
        }
    }
}
