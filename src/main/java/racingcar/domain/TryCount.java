package racingcar.domain;

import racingcar.util.TryCountException;

public class TryCount {
    public static final int MIN_COUNT = 1;

    private int count;

    public TryCount(String countString) {
        validateTryCount(countString);
        this.count = Integer.parseInt(countString);
    }

    public void minusTryCount() {
        this.count -= 1;
    }

    public boolean isRemainingTryCount() {
        return count > 0;
    }

    private void validateTryCount(String countString) {
        validateMismatchType(countString);
        validateMinCount(countString);
    }

    private void validateMismatchType(String countString) {
        try {
            Integer.parseInt(countString);
        } catch (NumberFormatException e) {
            throw new TryCountException.IllegalMismatchTypeException(countString);
        }
    }

    private void validateMinCount(String countString) {
        int countInteger = Integer.parseInt(countString);

        if (countInteger < MIN_COUNT)
            throw new TryCountException.IllegalMinCountException(countString);
    }
}
