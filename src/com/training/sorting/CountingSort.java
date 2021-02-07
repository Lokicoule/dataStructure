package com.training.sorting;

public class CountingSort {

    public static void sort(int[] arr, int max) {
        int[] counts = new int[max + 1];

        for (var item : arr)
            counts[item]++;

        var k = 0;
        for (var i = 0; i < counts.length; i++) {
            for (var j = counts[i]; j > 0; j--)
                arr[k++] = i;
        }
    }

    private static int findMaxValue(int[] arr) {
        var max = 0;
        for (var val : arr)
            max = Math.max(max, val);
        return max;
    }
}
