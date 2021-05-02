package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import racingcar.util.enums.ForwardStopStatus;

import static org.junit.jupiter.api.Assertions.*;
import static racingcar.util.ForwardStopPullUtil.*;

@DisplayName("전진/정지_랜덤_생성")
class ForwardStopPullUtilTest {

    @DisplayName("랜덤_숫자_생성_확인/0과_9사이")
    @RepeatedTest(value = 1_000, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
    void 랜덤_숫자_생성_확인_0과_9사이() {
        // Given
        int randomNumber = ForwardStopPullUtil.getRandomIntegerUnderMax();

        // When, Then
        assertAll(
                () -> assertTrue(MIN_PULL_NUMBER <= randomNumber),
                () -> assertTrue(randomNumber <= MAX_PULL_NUMBER)
        );
    }

    @DisplayName("전진_정지_정상_반환 확인")
    @RepeatedTest(value = 1_000, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
    void 전진_정지_정상_반환_확인() {
        // Given
        int randomNumber = ForwardStopPullUtil.getRandomIntegerUnderMax();

        // When, Then
        if (randomNumber < FORWARD_STOP_STANDARD) {
            assertEquals(judgeForwardStop(randomNumber), ForwardStopStatus.STOP);
        } else if  (randomNumber >= FORWARD_STOP_STANDARD) {
            assertEquals(judgeForwardStop(randomNumber), ForwardStopStatus.FORWARD);
        }
    }
}