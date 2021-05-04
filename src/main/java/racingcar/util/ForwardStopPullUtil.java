package racingcar.util;

import racingcar.util.enums.ForwardStopStatus;

import static racingcar.util.enums.ForwardStopStatus.FORWARD;
import static racingcar.util.enums.ForwardStopStatus.STOP;

public class ForwardStopPullUtil {

    public static final int FORWARD_STOP_STANDARD = 4;

    public static RandomGenerator randomGenerator = new DefaultRandomGenerator();

    public static ForwardStopStatus pullForwardStop() {
        return judgeForwardStop(randomGenerator.getRandomIntegerUnderMax());
    }

    public static ForwardStopStatus judgeForwardStop(int randomNumber) {
        if (randomNumber < FORWARD_STOP_STANDARD) {
            return STOP;
        }
        return FORWARD;
    }

    public static void changeRandomGenerator(RandomGenerator randomGeneratorArg) {
        randomGenerator = randomGeneratorArg;
    }
}
