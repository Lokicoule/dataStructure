package com.training.sorting;

public class MergeSort {

    public static void sort(int[] arr) {
        for (var i = 1; i < arr.length; i++) {
            var current = arr[i];
            var j = i - 1;
            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
    }
}
