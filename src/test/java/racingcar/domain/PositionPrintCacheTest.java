package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("위치_출력_캐시")
class PositionPrintCacheTest {

    @BeforeEach
    void 위치_출력_캐시_초기화() {
        PositionPrintCache.resetCache();
    }

    @Test
    void 위치_출력_정상_0부터_5까지() {
        // Given
        List<Integer> ints = Arrays.asList(0, 1, 2, 3, 4, 5);
        List<String> expectedResults = Arrays.asList("", "-", "--", "---", "----", "-----");


        for (int i = 0; i < ints.size(); i++) {
            // When
            String result = PositionPrintCache.getPositionPrint(ints.get(i));

            // Then
            assertEquals(expectedResults.get(i), result);
        }
    }

    @Test
    void 위치_출력_정상_동일한_위치_비중복_저장_확인() {
        // Given
        List<Integer> ints = Arrays.asList(0, 1, 1, 1, 1, 1);
        int expectedResult = 2;

        // When
        for (int i = 0; i < ints.size(); i++) {
            PositionPrintCache.getPositionPrint(ints.get(i));
        }

        // Then
        assertEquals(expectedResult, PositionPrintCache.getSize());
    }

    @Test
    void 위치_출력_정상_미사용_캐시_정리_확인() {
        // Given
        List<Integer> ints = Arrays.asList(0, 1, 2, 3, 4, 5);
        int removingIndex = 3;
        int expectedResult = 3;

        // When
        for (int i = 0; i < ints.size(); i++) {
            PositionPrintCache.getPositionPrint(ints.get(i));
        }
        PositionPrintCache.clearUnusedCache(removingIndex);

        // Then
        assertEquals(expectedResult, PositionPrintCache.getSize());
    }
}