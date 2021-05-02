package racingcar.util;

import static java.lang.String.format;
import static racingcar.domain.RacingCar.MAX_NAME_LENGTH;
import static racingcar.domain.RacingCar.MIN_NAME_LENGTH;
import static racingcar.domain.RacingCars.MIN_PLAYING_RACING_CARS_SIZE;

public class RacingCarException extends RuntimeException {
    private RacingCarException(String message) {
    }

    public static class IllegalRacingCarNameBoundaryException extends RacingCarException {
        public IllegalRacingCarNameBoundaryException(String playerInput) {
            super(format("경주할 자동차 이름을 %d자 이상, %d자 이하로 입력하세요 / 입력하신 이름: %s",
                    MIN_NAME_LENGTH,
                    MAX_NAME_LENGTH,
                    MIN_PLAYING_RACING_CARS_SIZE,
                    playerInput));
        }
    }
}
