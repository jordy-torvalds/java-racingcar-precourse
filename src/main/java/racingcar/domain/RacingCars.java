package racingcar.domain;

import racingcar.util.ForwardStopPullUtil;
import racingcar.util.RacingCarsException;
import racingcar.util.enums.ForwardStopStatus;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private List<RacingCar> racingCarList = new ArrayList<>();

    public RacingCars(String racingCarsName) {
        validateRacingCarsConstructor(racingCarsName);
        createRacingCar(racingCarsName);
        GameMetaData.Position.setDefaultUsableCount(this.getRacingCarListSize());
    }

    public void applyForwardStop() {
        for(RacingCar racingCar : racingCarList) {
            ForwardStopStatus forwardStopStatus = ForwardStopPullUtil.pullForwardStop();
            racingCar.applyForwardStop(forwardStopStatus);
        }
    }

    public void runRacingCarConsumer(RacingCarConsumer racingCarConsumer) {
        for(RacingCar racingCar : racingCarList) {
            racingCarConsumer.consume(racingCar);
        }
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
