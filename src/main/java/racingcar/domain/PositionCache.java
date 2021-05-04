package racingcar.domain;

import java.util.HashMap;
import java.util.Map;

public class PositionCache {

    private static Map<Integer, Position> cache = new HashMap<>();

    private PositionCache() {
    }

    public static Position getPosition(int key) {
        boolean isContained = cache.containsKey(key);
        Position position = null;

        if (isContained) {
            position = cache.get(key);
        } else if (!isContained) {
            position = new Position(key);
            cache.put(key, position);
        }

        return position;
    }

    public static void removePosition(int value) {
        cache.remove(value);
    }

    public static void resetCache() {
        cache = new HashMap<>();
    }

    public static int getSize() {
        return cache.size();
    }

    public static int getLowestKey() {
        int minimumKey = Integer.MAX_VALUE;
        for (Integer key : cache.keySet()) {
            minimumKey = Math.min(minimumKey, key);
        }
        return minimumKey;
    }

    public static int getHighestKey() {
        int highestKey = Integer.MIN_VALUE;
        for (Integer key : cache.keySet()) {
            highestKey = Math.max(highestKey, key);
        }
        return highestKey;
    }
}
