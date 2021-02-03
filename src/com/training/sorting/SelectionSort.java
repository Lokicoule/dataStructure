package com.training.sorting;

public class SelectionSort {

    public static void sort(int[] arr) {
        boolean isSorted;
        for (var i = 0; i < arr.length; i++) {
            isSorted = true;
            for (var j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                    isSorted = false;
                }
            }
            if (isSorted)
                return;
        }
    }

    private static void swap(int[] arr, int one, int two) {
        var temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }
}
