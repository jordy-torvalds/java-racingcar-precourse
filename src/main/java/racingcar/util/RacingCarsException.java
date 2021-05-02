package racingcar.util;

import static java.lang.String.format;
import static racingcar.domain.RacingCar.MAX_NAME_LENGTH;
import static racingcar.domain.RacingCar.MIN_NAME_LENGTH;
import static racingcar.domain.RacingCars.MIN_PLAYING_RACING_CARS_SIZE;

public class RacingCarsException extends RuntimeException {
    private RacingCarsException(String message) {
    }

    public static class IllegalRacingCarsNameLengthException extends RacingCarsException {
        public IllegalRacingCarsNameLengthException() {
            super(format("경주할 자동차 이름을 %d자 이상, %d자 이하로 해주시고, 각 자동차의 이름을 쉼표(,) 기준으로 구분해서 %d대 이상 입력하세요",
                    MIN_NAME_LENGTH,
                    MAX_NAME_LENGTH,
                    MIN_PLAYING_RACING_CARS_SIZE));
        }
    }

    public static class IllegalRacingCarsSizeException extends RacingCarsException {
        public IllegalRacingCarsSizeException(String playerInput) {
            super(format("경주할 자동차의 이름을 쉼표(,) 기준으로 구분해서 %d대 이상 입력하세요 / 입력하신 이름: %s",
                    MIN_PLAYING_RACING_CARS_SIZE,
                    playerInput));
        }
    }

    public static class IllegalRacingCarsNameEndException extends RacingCarsException {
        public IllegalRacingCarsNameEndException() {
            super("마지막에 입력하신 자동차의 이름이 유효하지 않습니다.");
        }
    }
}
