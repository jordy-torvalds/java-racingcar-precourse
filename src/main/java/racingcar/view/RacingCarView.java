package racingcar.view;

import racingcar.domain.Position;
import racingcar.domain.PositionPrintCache;
import racingcar.domain.RacingCars;

import static java.lang.String.format;

public class RacingCarView {

    public void runTry(RacingCars racingCars) {
        racingCars.applyForwardStop();
        racingCars.runRacingCarConsumer((racingCar) -> {
            Position position = racingCar.getPosition();
            String positionPrint = PositionPrintCache.getPositionPrint(position.getValue());
            System.out.println(format("%s:%s", racingCar.getName(), positionPrint));
        });
    }
}
