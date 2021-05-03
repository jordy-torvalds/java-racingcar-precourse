package racingcar.domain;

public class GameMetaData {
    public static class RacingCars {
        public static final int MIN_PLAYING_RACING_CARS_SIZE = 2;
        public static final int MAX_PLAYING_RACING_CARS_SIZE = Integer.MAX_VALUE;
    }

    public static class RacingCar {
        public static final int MIN_NAME_LENGTH = 1;
        public static final int MAX_NAME_LENGTH = 5;
    }

    public static class Position {
        public static final int DEFAULT_VALUE = 0;
        public static final int DEFAULT_INCREASE_VALUE = 1;
        private static int DEFAULT_USABLE_COUNT = 0;

        public static void setDefaultUsableCount(int defaultUsableCount) {
            DEFAULT_USABLE_COUNT = defaultUsableCount;
        }

        public static int getDefaultUsableCount() {
            return DEFAULT_USABLE_COUNT;
        }
    }
}
