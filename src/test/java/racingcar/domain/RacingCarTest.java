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
        assertDoesNotThrow(() -> new RacingCar(racingCarName));
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

    @Test
    @DisplayName("자동차_위치_정상/최초_초기화시_캐싱_위치간_동일_여부")
    void 자동차_위치_객체_도메인_정상_최초_초기화시_캐싱_위치간_동일_여부() {
        // Given
        RacingCar racingCarOne = new RacingCar("죠르디");
        RacingCar racingCarTwo = new RacingCar("스카피");
        RacingCar racingCarThree = new RacingCar("앙몬드");

        // When
        Position positionOne = racingCarOne.getPosition();
        Position positionTwo = racingCarTwo.getPosition();
        Position positionThree = racingCarThree.getPosition();

        // Then
        assertEquals(positionOne, positionTwo);
        assertEquals(positionTwo, positionThree);
        assertEquals(positionOne, positionThree);
    }

    @Test
    @DisplayName("자동차_위치_정상/일부_자동차_전진_후_캐싱_위치간_동일_여부")
    void 자동차_위치_도메인_정상_일부_자동차_전진_후_캐싱_위치간_동일_여부() {
        // Given
        RacingCar racingCarOne = new RacingCar("죠르디");
        RacingCar racingCarTwo = new RacingCar("스카피");
        RacingCar racingCarThree = new RacingCar("앙몬드");


        // When
        racingCarOne.applyForwardStop(FORWARD);
        racingCarThree.applyForwardStop(FORWARD);

        Position positionOne = racingCarOne.getPosition();
        Position positionTwo = racingCarTwo.getPosition();
        Position positionThree = racingCarThree.getPosition();

        // Then
        assertEquals(positionOne, positionThree);
        assertNotEquals(positionOne, positionTwo);
        assertNotEquals(positionTwo, positionThree);
    }

    @Test
    @DisplayName("자동차_위치_도메인_정상/자동차_두번_전진_후_위치_캐시_사이즈_케이스1")
    void 자동차_위치_도메인_정상_전체_자동차_두번_전진_후_위치_캐시_사이즈_케이스1() {
        // Given
        GameMetaData.Position.setDefaultUsableCount(3);

        RacingCar racingCarOne = new RacingCar("죠르디");
        RacingCar racingCarTwo = new RacingCar("스카피");
        RacingCar racingCarThree = new RacingCar("앙몬드");

        int expectedPositionCacheSize = 2;

        // When
        racingCarOne.applyForwardStop(FORWARD);
        racingCarOne.applyForwardStop(FORWARD);
        racingCarTwo.applyForwardStop(FORWARD);
        racingCarThree.applyForwardStop(FORWARD);
        ;
        racingCarThree.applyForwardStop(FORWARD);

        // Then
        assertEquals(expectedPositionCacheSize, PositionCache.getSize());
    }

    @Test
    @DisplayName("자동차_위치_도메인_정상/자동차_두번_전진_후_위치_캐시_사이즈_케이스2")
    void 자동차_위치_도메인_정상_전체_자동차_두번_전진_후_위치_캐시_사이즈_케이스2() {
        // Given
        GameMetaData.Position.setDefaultUsableCount(3);

        RacingCar racingCarOne = new RacingCar("죠르디");
        RacingCar racingCarTwo = new RacingCar("스카피");
        RacingCar racingCarThree = new RacingCar("앙몬드");

        int expectedPositionCacheSize = 1;

        // When
        racingCarOne.applyForwardStop(FORWARD);
        racingCarOne.applyForwardStop(FORWARD);
        racingCarTwo.applyForwardStop(FORWARD);
        racingCarTwo.applyForwardStop(FORWARD);
        racingCarThree.applyForwardStop(FORWARD);
        racingCarThree.applyForwardStop(FORWARD);

        // Then
        assertEquals(expectedPositionCacheSize, PositionCache.getSize());
    }
}