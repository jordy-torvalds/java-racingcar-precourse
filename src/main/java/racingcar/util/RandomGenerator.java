package racingcar.util;

public interface RandomGenerator {
    public static final int MIN_PULL_NUMBER = 0;
    public static final int MAX_PULL_NUMBER = 9;

    public int getRandomIntegerUnderMax();

}
