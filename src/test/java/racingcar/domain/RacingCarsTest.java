package racingcar.domain;

import org.junit.jupiter.api.*;
import racingcar.util.RacingCarException;
import racingcar.util.RacingCarsException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("경주_자동차들")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RacingCarsTest {

    @Order(1)
    @Test
    @DisplayName("자동차_생성_정상")
    void 자동차_생성_정상() {
        // Given
        String racingCarsName = "죠르디,스카피,앙몬드";

        // When, Then
        assertDoesNotThrow(() -> new RacingCars(racingCarsName));
    }

    @Order(2)
    @Test
    @DisplayName("자동차_생성_예외/플레이어_이름_0글자_입력")
    void 자동차_생성_예외_플레이어_이름_0글자_입력() {
        // Given
        String racingCarsName = "";

        // When, Then
        assertThrows(RacingCarsException.IllegalRacingCarsNameLengthException.class
                , () -> new RacingCars(racingCarsName));
    }

    @Order(3)
    @Test
    @DisplayName("자동차_생성_예외/두_개_미만의_이름_입력")
    void 자동차_생성_예외_두_개_미만의_이름_입력() {
        // Given
        String racingCarsName = "죠르디!@";

        // When, Then
        assertThrows(RacingCarsException.IllegalRacingCarsSizeException.class
                , () -> new RacingCars(racingCarsName));
    }

    @Order(4)
    @Test
    @DisplayName("자동차_생성_예외/쉼표로_끝나는_이름_입력")
    void 자동차_생성_예외_쉼표로_끝나는_이름_입력() {
        // Given
        String racingCarsName = "죠르디,스카피,";

        // When, Then
        assertThrows(RacingCarsException.IllegalRacingCarsNameEndException.class
                , () -> new RacingCars(racingCarsName));
    }

    @Order(5)
    @Test
    @DisplayName("자동차_생성_예외/6글자_이상의_자동차_이름_입력_케이스1")
    void 자동차_생성_예외_6글자_이상의_자동차_이름_입력_케이스1() {
        // Given
        String racingCarsName = "죠르디토르발즈,스카피";

        // When, Then
        assertThrows(RacingCarException.IllegalRacingCarNameBoundaryException.class
                , () -> new RacingCars(racingCarsName));
    }

    @Order(6)
    @Test
    @DisplayName("자동차_생성_예외/6글자_이상의_자동차_이름_입력_케이스2")
    void 자동차_생성_예외_6글자_이상의_자동차_이름_입력_케이스2() {
        // Given
        String racingCarsName = "죠르디,요리사_스카피";

        // When, Then
        assertThrows(RacingCarException.IllegalRacingCarNameBoundaryException.class
                , () -> new RacingCars(racingCarsName));
    }
}
