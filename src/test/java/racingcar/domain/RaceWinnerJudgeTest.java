package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.ForwardStopPullUtil;
import racingcar.util.MockRandomGenerator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static racingcar.domain.RaceWinnerJudge.clearWinners;

@DisplayName("우승자_판정")
class RaceWinnerJudgeTest {

    @BeforeEach
    void 우승자_정보_초기화() {
        clearWinners();
    }

    @ParameterizedTest
    @ValueSource(strings = {"죠르디/411", "스카피/423 245 263", "스카피,앙몬드/111 147 157"})
    @DisplayName("우승자_판정_테스트")
    void 우승자_판정_테스트(String arg) {
        // Given
        String[] args = arg.split("/");
        String result = args[0];
        String[] randomNumbersArray = args[1].split(" ");

        String racingCarsName = "죠르디,스카피,앙몬드";
        RacingCars racingCars = new RacingCars(racingCarsName);


        // When
        for(String randomNumbers : randomNumbersArray) {
            int[] randomNumberIntArray = parseIntArray(randomNumbers);
            ForwardStopPullUtil.changeRandomGenerator(new MockRandomGenerator(randomNumberIntArray));
            racingCars.applyForwardStop();
        }

        String winners = RaceWinnerJudge.getRaceWinner(racingCars);


        // Then
        assertEquals(result, winners);
    }

    int[] parseIntArray(String randomNumbers) {
        String[] randomNumberArray = randomNumbers.split("");
        int[] result = new int[randomNumberArray.length];

        for (int i = 0; i < randomNumberArray.length; i++) {
            result[i] = Integer.parseInt(randomNumberArray[i]);
        }

        return result;
    }
}