package racingcar.domain;

import racingcar.util.RacingCarsException;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    public static final int MIN_PLAYING_RACING_CARS_SIZE = 2;
    public static final int MAX_PLAYING_RACING_CARS_SIZE = Integer.MAX_VALUE;

    private List<RacingCar> racingCarList = new ArrayList<>();

    public RacingCars(String racingCarsName) {
        validateRacingCarsConstructor(racingCarsName);
        createRacingCar(racingCarsName);
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
