package racingcar.util;

import java.util.Random;

public class DefaultRandomGenerator implements RandomGenerator {

    private final Random random = new Random();

    public int getRandomIntegerUnderMax() {
        return random.nextInt(MAX_PULL_NUMBER);
    }
}
