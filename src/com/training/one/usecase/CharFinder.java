package com.training.one.usecase;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharFinder {
    public static char findFistNonRepeatedChar(String input) {
        if (input.isEmpty()) throw new IllegalArgumentException();

        Map<Character, Integer> map = new HashMap<>();
        var chars = input.toLowerCase().toCharArray();
        for (char c : chars) {
            var count = map.containsKey(c) ? map.get(c) : 0;
            map.put(c, count + 1);
        }
        for (var ch : chars)
            if (map.get(ch) == 1)
                return ch;
        return Character.MIN_VALUE;
    }

    public static char findFirstRepeatedChar(String input) {
        if (input.isEmpty()) throw new IllegalArgumentException();

        Set<Character> set = new HashSet<>();
        var chars = input.toLowerCase().toCharArray();
        for (char ch : chars) {
            if (set.contains(ch)) return ch;
            set.add(ch);
        }
        return Character.MIN_VALUE;
    }
}
