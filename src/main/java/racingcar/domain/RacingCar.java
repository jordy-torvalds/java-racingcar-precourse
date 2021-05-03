package racingcar.domain;

import racingcar.util.RacingCarException;
import racingcar.util.enums.ForwardStopStatus;

import static racingcar.domain.GameMetaData.RacingCar.MAX_NAME_LENGTH;
import static racingcar.domain.GameMetaData.RacingCar.MIN_NAME_LENGTH;
import static racingcar.util.enums.ForwardStopStatus.FORWARD;

public class RacingCar {

    private String name;
    private Position position;

    public RacingCar(String racingCarName) {
        validateRacingCarNameBoundary(racingCarName);

        this.name = racingCarName;
        this.position = Position.of();
    }

    public void applyForwardStop(ForwardStopStatus forwardStopStatus) {
        if (forwardStopStatus.equals(FORWARD)) {
            this.position = position.plusPosition();
        }
    }

    public String getName() {
        return this.name;
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
