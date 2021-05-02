package racingcar.domain;

public class Position {
    private int value;

    public Position () {
        value = 0;
    }

    public void plusPosition() {
        this.value += 1;
    }

    public int getValue() {
        return value;
    }
}
