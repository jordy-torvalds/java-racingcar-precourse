package racingcar.view;

import racingcar.domain.Position;
import racingcar.domain.PositionPrintCache;
import racingcar.domain.RacingCars;
import racingcar.util.RacingCarException;
import racingcar.util.RacingCarsException;

import java.util.Optional;
import java.util.Scanner;

import static java.lang.String.format;

public class RacingCarView {

    private final String MESSAGE_ANSWER_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final Scanner sc = new Scanner(System.in);

    public void run() {
        initializeRacingCars();
//        initializeTryCount();
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

    public void runTry(RacingCars racingCars) {
        racingCars.applyForwardStop();
        racingCars.runRacingCarConsumer((racingCar) -> {
            Position position = racingCar.getPosition();
            String positionPrint = PositionPrintCache.getPositionPrint(position.getValue());
            System.out.println(format("%s:%s", racingCar.getName(), positionPrint));
        });
    }
}
