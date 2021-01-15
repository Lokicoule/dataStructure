package com.training.one.usecase;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashTableExercices {
    public static int mostFrequent(int[] numbers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int nb : numbers) {
            var count = map.containsKey(nb) ? map.get(nb) + 1 : 1;
            map.put(nb, count);
        }
        int max = Integer.MIN_VALUE;
        var result = numbers[0];
        for (var item : map.entrySet()) {
            if (max < item.getValue()) {
                max = item.getValue();
                result = item.getKey();
            }
        }
        return result;
    }

    public static int countPairsWithDiff(int[] numbers, int difference) {
        int count = 0;
        Set<Integer> set = new HashSet<>();

        for (int nb : numbers)
            set.add(nb);

        for (var nb : numbers) {
            if (set.contains(nb + difference))
                count++;
            if (set.contains(nb - difference))
                count++;
            set.remove(nb);
        }
        return count;
    }

    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int diff = target - numbers[i];
            if (map.containsKey(diff))
                return new int[]{map.get(diff), i};
            map.put(numbers[i], i);
        }
        return null;
    }
}
