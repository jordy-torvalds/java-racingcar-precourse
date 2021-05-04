package racingcar.domain;

public class GameMetaData {

    private GameMetaData() {
    }

    public static class RacingCars {

        private RacingCars() {
        }

        public static final int MIN_PLAYING_RACING_CARS_SIZE = 2;
        public static final int MAX_PLAYING_RACING_CARS_SIZE = Integer.MAX_VALUE;
    }

    public static class RacingCar {

        private RacingCar() {
        }

        public static final int MIN_NAME_LENGTH = 1;
        public static final int MAX_NAME_LENGTH = 5;
    }

    public static class Position {

        private Position() {
        }

        public static final int DEFAULT_VALUE = 0;
        public static final int DEFAULT_INCREASE_VALUE = 1;
        private static int defaultUsableCount = 0;

        public static void setDefaultUsableCount(int defaultUsableCountArg) {
            defaultUsableCount = defaultUsableCountArg;
        }

        public static int getDefaultUsableCount() {
            return defaultUsableCount;
        }
    }
}
