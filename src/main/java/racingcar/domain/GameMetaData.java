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
            if (DEFAULT_USABLE_COUNT == 0) {
                DEFAULT_USABLE_COUNT = defaultUsableCount;
            } else if (DEFAULT_USABLE_COUNT != 0) {
                throw new IllegalArgumentException("최초 위치 도메인의 사용 가능 횟수 설정 이후에는 변경이 불가합니다.");
            }
        }

        public static int getDefaultUsableCount() {
            return DEFAULT_USABLE_COUNT;
        }
    }
}
