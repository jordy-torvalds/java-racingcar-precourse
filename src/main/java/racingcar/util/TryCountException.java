package racingcar.util;

import static java.lang.String.format;
import static racingcar.domain.TryCount.MIN_COUNT;

public class TryCountException extends RuntimeException {

    public TryCountException(String message) {
        super(message);
    }

    public static class IllegalMismatchTypeException extends TryCountException {
        public IllegalMismatchTypeException(String playerInput) {
            super(format("재시도 횟수는 %d 이상의 정수를 입력해주세요. / 입력하신 재시도 횟수: %s",
                    MIN_COUNT,
                    playerInput));
        }
    }

    public static class IllegalMinCountException extends TryCountException {
        public IllegalMinCountException(String playerInput) {
            super(format("재시도 횟수는 %d 이상의 정수를 입력해주세요. / 입력하신 재시도 횟수: %s",
                    MIN_COUNT,
                    playerInput));
        }
    }

}
