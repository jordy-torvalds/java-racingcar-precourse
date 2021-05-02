package racingcar.domain;

import java.util.HashMap;
import java.util.Map;

public class PositionCache {

    private static Map<Integer, Position> cache = new HashMap<>();

    private PositionCache () {
    }

    public static Position getPosition(int key) {
        boolean isContained = cache.containsKey(key);
        Position position = null;

        if (isContained == true) {
            position = cache.get(key);
        } else if (isContained == false) {
            position = new Position(key);
            cache.put(key, position);
        }

        return position;
    }

    public static void removePosition(int value) {
        cache.remove(value);
    }

    public static int getSize() {
        return cache.size();
    }
}
