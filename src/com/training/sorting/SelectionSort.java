package com.training.sorting;

public class SelectionSort {

    public static void sort(int[] arr) {
        for (var i = 0; i < arr.length; i++) {
            int minIdx = findMinIdx(arr, i);
            if (i != minIdx)
                swap(arr, minIdx, i);
        }
    }

    private static int findMinIdx(int[] arr, int i) {
        var minIdx = i;
        for (var j = i; j < arr.length; j++) {
            if (arr[j] < arr[minIdx])
                minIdx = j;
        }
        return minIdx;
    }

    private static void swap(int[] arr, int one, int two) {
        var temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }
}
