package racingcar.util;

import racingcar.util.enums.ForwardStopStatus;

import java.util.Random;

import static racingcar.util.enums.ForwardStopStatus.FORWARD;
import static racingcar.util.enums.ForwardStopStatus.STOP;

public class ForwardStopPullUtil {
    public static final int MIN_PULL_NUMBER = 0;
    public static final int MAX_PULL_NUMBER = 9;

    public static final int FORWARD_STOP_STANDARD = 4;

    private static final Random random = new Random();

    public static ForwardStopStatus pullForwardStop() {
        int randomNumber = getRandomIntegerUnderMax();

        return judgeForwardStop(randomNumber);
    }

    public static ForwardStopStatus judgeForwardStop(int randomNumber) {
        if (randomNumber < FORWARD_STOP_STANDARD) {
            return STOP;
        }
        return FORWARD;
    }

    public static int getRandomIntegerUnderMax() {
        return random.nextInt(MAX_PULL_NUMBER);
    }
}
