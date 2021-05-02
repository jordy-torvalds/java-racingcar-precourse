package racingcar.domain;

public class Position {
    private int value;
    private int usableCount;

    private Position() {
    }

    Position(int value) {
        this.value = value;
        this.usableCount = GameMetaData.Position.getDefaultUsableCount();
    }

    public Position plusPosition() {
        this.minusUsableCount();
        return PositionCache.getPosition(value + GameMetaData.Position.DEFAULT_INCREASE_VALUE);
    }

    public int getValue() {
        return value;
    }

    public static Position of() {
        return of(GameMetaData.Position.DEFAULT_VALUE);
    }

    public static Position of(int value) {
        return PositionCache.getPosition(value);
    }

    private int getUsableCount() {
        return usableCount;
    }

    private void minusUsableCount() {
        this.usableCount -= 1;

        if (usableCount == 0) {
            PositionCache.removePosition(value);
        }
    }
}
