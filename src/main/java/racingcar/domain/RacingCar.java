package racingcar.domain;

import racingcar.util.ForwardStopPullUtil;
import racingcar.util.RacingCarException;
import racingcar.util.enums.ForwardStopStatus;

import static racingcar.util.enums.ForwardStopStatus.FORWARD;

public class RacingCar {
    public static final int MIN_NAME_LENGTH = 1;
    public static final int MAX_NAME_LENGTH = 5;

    private String name;
    private Position position;

    public RacingCar(String racingCarName) {
        validateRacingCarNameBoundary(racingCarName);

        this.name = racingCarName;
        this.position = new Position();
    }

    public void applyForwardStop(ForwardStopStatus forwardStopStatus) {
        if (forwardStopStatus.equals(FORWARD)) {
            this.position.plusPosition();
        }
    }

    public Position getPosition() {
        return this.position;
    }

    private void validateRacingCarNameBoundary(String racingCarName) {
        if(racingCarName.length() < MIN_NAME_LENGTH
                || MAX_NAME_LENGTH < racingCarName.length()) {
            throw new RacingCarException.IllegalRacingCarNameBoundaryException(racingCarName);
        }
    }
}
