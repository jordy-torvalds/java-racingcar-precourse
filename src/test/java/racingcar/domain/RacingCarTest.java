package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import racingcar.util.RacingCarException;

import static org.junit.jupiter.api.Assertions.*;
import static racingcar.util.enums.ForwardStopStatus.FORWARD;
import static racingcar.util.enums.ForwardStopStatus.STOP;

@DisplayName("경주_자동차")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RacingCarTest {

    @Test
    @DisplayName("자동차_생성_정상")
    void 자동차_생성_정상() {
        // Given
        String racingCarName = "죠르디";

        // When, Then
        assertDoesNotThrow(()->new RacingCar(racingCarName));
    }

    @Test
    @DisplayName("자동차_생성_예외/1글자_미만_이름")
    void 자동차_생성_예외_1글자_미만_이름() {
        // Given
        String racingCarName = "";

        // When, Then
        assertThrows(RacingCarException.IllegalRacingCarNameBoundaryException.class,
                () -> new RacingCar(racingCarName));
    }

    @Test
    @DisplayName("자동차_생성_예외/6글자_이상_이름")
    void 자동차_생성_예외_6글자_이상_이름() {
        // Given
        String racingCarName = "죠르디_토르발즈";

        // When, Then
        assertThrows(RacingCarException.IllegalRacingCarNameBoundaryException.class,
                () -> new RacingCar(racingCarName));
    }

    @Test
    @DisplayName("자동차_전진_중지_적용_정상/전진")
    void 자동차_전진_중지_적용_정상_전진() {
        // Given
        RacingCar racingCar = new RacingCar("죠르디");
        int expectedPositionValue = 1;

        // When
        racingCar.applyForwardStop(FORWARD);
        Position position = racingCar.getPosition();

        // Then
        assertEquals(expectedPositionValue, position.getValue());
    }

    @Test
    @DisplayName("자동차_전진_중지_적용_정상/정지")
    void 자동차_전진_중지_적용_정상_정지() {
        // Given
        RacingCar racingCar = new RacingCar("죠르디");
        int expectedPositionValue = 0;

        // When
        racingCar.applyForwardStop(STOP);
        Position position = racingCar.getPosition();

        // Then
        assertEquals(expectedPositionValue, position.getValue());
    }
}