package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("위치 캐시")
class PositionCacheTest {

    @BeforeEach
    void 캐시_초기화() {
        PositionCache.resetCache();
    }

    @ParameterizedTest
    @ValueSource(strings = {"111,1", "1122,2", "112234,4", "111222,2"})
    @DisplayName("캐싱_기능_테스트_케이스1")
    void 캐싱_기능_테스트(String arg) {
        // Given
        String[] args = arg.split(",");
        String[] positionValues = args[0].split("");
        int result = Integer.parseInt(args[1]);

        // When
        for (String positionValue : positionValues) {
            PositionCache.getPosition(Integer.parseInt(positionValue));
        }

        // then
        assertEquals(result, PositionCache.getSize());
    }

    @ParameterizedTest
    @ValueSource(strings = {"111,1,0", "1122,1,1", "112234,12,2", "12345,123,2"})
    @DisplayName("캐싱_삭제_기능_테스트")
    void 캐싱_삭제_기능_테스트(String arg) {
        // Given
        String[] args = arg.split(",");
        String[] positionValues = args[0].split("");
        String[] removeIndexes = args[1].split("");
        int result = Integer.parseInt(args[2]);

        // When
        for (String positionValue : positionValues) {
            PositionCache.getPosition(Integer.parseInt(positionValue));
        }

        for (String removeIndex : removeIndexes) {
            PositionCache.removePosition(Integer.parseInt(removeIndex));
        }

        // then
        assertEquals(result, PositionCache.getSize());
    }

    @ParameterizedTest
    @ValueSource(strings = {"111,1", "1122,1", "2234,2", "456,4"})
    @DisplayName("캐싱_가장_낮은_위치_값_조회_테스트")
    void 캐싱_가장_낮은_위치_값_조회_테스트(String arg) {
        // Given
        String[] args = arg.split(",");
        String[] positionValues = args[0].split("");
        int result = Integer.parseInt(args[1]);

        // When
        for (String positionValue : positionValues) {
            PositionCache.getPosition(Integer.parseInt(positionValue));
        }

        // then
        assertEquals(result, PositionCache.getLowestKey());
    }

    @ParameterizedTest
    @ValueSource(strings = {"12,2", "112233,3", "2234,4", "456,6"})
    @DisplayName("캐싱_가장_높은_위치_값_조회_테스트")
    void 캐싱_가장_높은_위치_값_조회_테스트(String arg) {
        // Given
        String[] args = arg.split(",");
        String[] positionValues = args[0].split("");
        int result = Integer.parseInt(args[1]);

        // When
        for (String positionValue : positionValues) {
            PositionCache.getPosition(Integer.parseInt(positionValue));
        }

        // then
        assertEquals(result, PositionCache.getHighestKey());
    }
}