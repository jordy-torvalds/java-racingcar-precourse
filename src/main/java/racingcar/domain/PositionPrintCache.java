package racingcar.domain;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class PositionPrintCache {
    private static Map<Integer, String> cache = new TreeMap<>();

    public static int getSize() {
        return cache.size();
    }

    public static String getPositionPrint(int key) {
        boolean isContained = cache.containsKey(key);
        String positionPrint = null;

        if (isContained == true) {
            positionPrint = cache.get(key);
        } else if (isContained == false) {
            cache.put(key, createNewCache(key));
            positionPrint = cache.get(key);
        }
        return positionPrint;
    }

    public static void clearUnusedCache(int lowestValue) {

        ArrayList<Integer> cacheKeyList = new ArrayList<>(cache.keySet());
        int removingTargetIndex = Math.max(GameMetaData.Position.DEFAULT_INCREASE_VALUE,
                lowestValue - GameMetaData.Position.DEFAULT_INCREASE_VALUE);

        for (Integer cacheKey : cacheKeyList) {
            removeMinValue(cacheKey, removingTargetIndex);
        }
    }

    private static void removeMinValue(int key, int minValue) {
        if (key <= minValue) {
            cache.remove(key);
        }
    }

    private static String createNewCache(int key) {
        String newCache = null;
        if (key == 0) {
            newCache = new String("");
        } else if (key >= GameMetaData.Position.DEFAULT_INCREASE_VALUE) {
            newCache = createNewCacheString(key);
        }
        return newCache;
    }

    private static String createNewCacheString(int key) {
        String result = cache.getOrDefault(key - GameMetaData.Position.DEFAULT_INCREASE_VALUE, "");

        for (int i = 0; i < GameMetaData.Position.DEFAULT_INCREASE_VALUE; i++) {
            result += "-";
        }

        return new String(result);
    }
}
