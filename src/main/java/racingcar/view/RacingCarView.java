package racingcar.view;

import racingcar.domain.*;
import racingcar.util.RacingCarException;
import racingcar.util.RacingCarsException;
import racingcar.util.TryCountException;

import java.util.Optional;
import java.util.Scanner;

import static java.lang.String.format;

public class RacingCarView {

    public static final String MESSAGE_ANSWER_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String MESSAGE_ANSWER_TRY_COUNT = "시도할 회수는 몇회인가요?";
    public static final String MESSAGE_RUN_RESULT = "실행결과";
    public static final String MESSAGE_WINNER_RESULT = "가 최종 우승했습니다.";
    private final Scanner sc = new Scanner(System.in);

    public void run() {
        RacingCars racingCars = initializeRacingCars();
        TryCount tryCount = initializeTryCount();
        gameStart(racingCars, tryCount);
    }

    private void gameStart(RacingCars racingCars, TryCount tryCount) {
        System.out.println(MESSAGE_RUN_RESULT);
        while (tryCount.isRemainingTryCount()) {
            runTry(racingCars);
            clearPositionPrintCache();
            tryCount.minusTryCount();
        }
        printWinner(racingCars);
    }

    void runTry(RacingCars racingCars) {
        racingCars.applyForwardStop();
        String raceProgressString = ProgressBroadcast.createRaceProgressString(racingCars);

        System.out.print(raceProgressString);
    }

    void clearPositionPrintCache() {
        int minimumPosition = PositionCache.getLowestKey();
        PositionPrintCache.clearUnusedCache(minimumPosition);
    }

    private RacingCars initializeRacingCars() {
        boolean isContinued = true;
        Optional<RacingCars> optionalRacingCars = null;
        System.out.println(MESSAGE_ANSWER_CAR_NAME);
        while (isContinued) {
            optionalRacingCars = createRacingCar();
            isContinued = !optionalRacingCars.isPresent();
        }
        return optionalRacingCars.get();
    }

    private Optional<RacingCars> createRacingCar() {
        Optional<RacingCars> optionalRacingCars = null;
        try {
            String enteredCarName = sc.nextLine();
            RacingCars racingCars = new RacingCars(enteredCarName);
            optionalRacingCars = Optional.of(racingCars);
        } catch (RacingCarsException | RacingCarException e) {
            System.out.println(e.getMessage());
            optionalRacingCars = Optional.ofNullable(null);
        }
        return optionalRacingCars;
    }

    private TryCount initializeTryCount() {
        boolean isContinued = true;
        Optional<TryCount> optionalTryCount = null;
        System.out.println(MESSAGE_ANSWER_TRY_COUNT);
        while (isContinued) {
            optionalTryCount = createTryCount();
            isContinued = !optionalTryCount.isPresent();
        }
        return optionalTryCount.get();
    }

    private Optional<TryCount> createTryCount() {
        Optional<TryCount> optionalTryCount = null;
        try {
            String enteredTryCount = sc.nextLine();
            TryCount tryCount = new TryCount(enteredTryCount);
            optionalTryCount = Optional.of(tryCount);
        } catch (TryCountException e) {
            System.out.println(e.getMessage());
            optionalTryCount = Optional.ofNullable(null);
        }
        return optionalTryCount;
    }

    private void printWinner(RacingCars racingCars) {
        String winners = RaceWinnerJudge.getRaceWinner(racingCars);

        System.out.println(format("%s%s", winners, MESSAGE_WINNER_RESULT));
    }
}
