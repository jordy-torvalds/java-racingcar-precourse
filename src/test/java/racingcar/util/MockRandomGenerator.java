package racingcar.util;

import java.util.LinkedList;
import java.util.Queue;

public class MockRandomGenerator implements RandomGenerator {

    Queue<Integer> randomIntegerQueue = new LinkedList<Integer>();

    public int getRandomIntegerUnderMax() {
        return randomIntegerQueue.poll();
    }

    public MockRandomGenerator(int... randomInteger) {
        for (int eachRandomInteger : randomInteger) {
            randomIntegerQueue.add(eachRandomInteger);
        }
    }
}
