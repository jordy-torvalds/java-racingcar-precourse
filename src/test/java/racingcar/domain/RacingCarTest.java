package racingcar.domain;

import org.junit.jupiter.api.*;
import racingcar.util.RacingCarException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
}