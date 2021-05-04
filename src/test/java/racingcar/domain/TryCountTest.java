package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.TryCountException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("재시도_횟수")
class TryCountTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,false", "2,true"})
    @DisplayName("재시도_횟수_잔여_확인_기능_테스트")
    void 재시도_횟수_잔여_확인_기능_테스트(String arg) {
        // Given
        String[] args = arg.split(",");
        String tryCountArg = args[0];
        String resultString = args[1];
        boolean expectedResult = Boolean.parseBoolean(resultString);

        // When
        TryCount tryCount = new TryCount(tryCountArg);
        tryCount.minusTryCount();

        // Then
        assertEquals(expectedResult, tryCount.isRemainingTryCount());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "3", "5", "7"})
    @DisplayName("재시도_횟수_입력_정상")
    void 재시도_횟수_입력_정상(String args) {
        assertDoesNotThrow(() -> new TryCount(args));
    }

    @ParameterizedTest
    @ValueSource(strings = {"!@", "문자", "3.213", "gfg"})
    @DisplayName("재시도_횟수_예외/비숫자_문자열_입력")
    void 재시도_횟수_예외_비숫자_문자열(String args) {
        assertThrows(TryCountException.IllegalMismatchTypeException.class
                , () -> new TryCount(args));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-3", "-5", "-10"})
    @DisplayName("재시도_횟수_예외/0_미만_정수_입력")
    void 재시도_횟수_예외_0_미만_정수_입력(String args) {
        assertThrows(TryCountException.IllegalMinCountException.class
                , () -> new TryCount(args));
    }
}