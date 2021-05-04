package racingcar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCars;
import racingcar.util.ForwardStopPullUtil;
import racingcar.util.MockRandomGenerator;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("자동차 경주 뷰")
class RacingCarViewTest {
    private final ByteArrayOutputStream OUT_CONTENT = new ByteArrayOutputStream();
    private final ByteArrayOutputStream ERR_CONTENT = new ByteArrayOutputStream();
    private final StringBuilder RESULT_BUILDER = new StringBuilder();
    private final String RESULT_TEMPLATE = "%s:%s\r\n";

    private RacingCarView racingCarView = new RacingCarView();
    private RacingCars racingCars = new RacingCars("죠르디,스카피,앙몬드");

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(OUT_CONTENT));
        System.setErr(new PrintStream(ERR_CONTENT));

        RESULT_BUILDER.setLength(0);
    }

    @Test
    @DisplayName("회차별_처리_정상_케이스1")
    void 회차별_처리_정상_케이스1() {
        // Given
        ForwardStopPullUtil.changeRandomGenerator(new MockRandomGenerator(4, 1, 5));

        RESULT_BUILDER.append(format(RESULT_TEMPLATE, "죠르디", "-"));
        RESULT_BUILDER.append(format(RESULT_TEMPLATE, "스카피", ""));
        RESULT_BUILDER.append(format(RESULT_TEMPLATE, "앙몬드", "-"));

        // When
        racingCarView.runTry(racingCars);

        // Then
        assertEquals(RESULT_BUILDER.toString(), OUT_CONTENT.toString());
    }

    @Test
    @DisplayName("회차별_처리_정상_케이스2")
    void 회차별_처리_정상_케이스2() {
        // Given
        ForwardStopPullUtil.changeRandomGenerator(new MockRandomGenerator(4, 1, 1));

        RESULT_BUILDER.append(format(RESULT_TEMPLATE, "죠르디", "-"));
        RESULT_BUILDER.append(format(RESULT_TEMPLATE, "스카피", ""));
        RESULT_BUILDER.append(format(RESULT_TEMPLATE, "앙몬드", ""));

        // When
        racingCarView.runTry(racingCars);

        // Then
        assertEquals(RESULT_BUILDER.toString(), OUT_CONTENT.toString());
    }

    @Test
    @DisplayName("회차별_처리_정상_케이스3")
    void 회차별_처리_정상_케이스3() {
        // Given
        ForwardStopPullUtil.changeRandomGenerator(new MockRandomGenerator(4, 1, 1, 5, 2, 4));

        RESULT_BUILDER.append(format(RESULT_TEMPLATE, "죠르디", "-"));
        RESULT_BUILDER.append(format(RESULT_TEMPLATE, "스카피", ""));
        RESULT_BUILDER.append(format(RESULT_TEMPLATE, "앙몬드", ""));
        RESULT_BUILDER.append(format(RESULT_TEMPLATE, "죠르디", "--"));
        RESULT_BUILDER.append(format(RESULT_TEMPLATE, "스카피", ""));
        RESULT_BUILDER.append(format(RESULT_TEMPLATE, "앙몬드", "-"));

        // When
        racingCarView.runTry(racingCars);
        racingCarView.runTry(racingCars);

        // Then
        assertEquals(RESULT_BUILDER.toString(), OUT_CONTENT.toString());
    }

    @Test
    @DisplayName("회차별_처리_정상_케이스4")
    void 회차별_처리_정상_케이스4() {
        // Given
        ForwardStopPullUtil.changeRandomGenerator(new MockRandomGenerator(4, 7, 7, 1, 2, 6));

        RESULT_BUILDER.append(format(RESULT_TEMPLATE, "죠르디", "-"));
        RESULT_BUILDER.append(format(RESULT_TEMPLATE, "스카피", "-"));
        RESULT_BUILDER.append(format(RESULT_TEMPLATE, "앙몬드", "-"));
        RESULT_BUILDER.append(format(RESULT_TEMPLATE, "죠르디", "-"));
        RESULT_BUILDER.append(format(RESULT_TEMPLATE, "스카피", "-"));
        RESULT_BUILDER.append(format(RESULT_TEMPLATE, "앙몬드", "--"));

        // When
        racingCarView.runTry(racingCars);
        racingCarView.runTry(racingCars);

        // Then
        assertEquals(RESULT_BUILDER.toString(), OUT_CONTENT.toString());
    }

}