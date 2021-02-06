package com.training.sorting;

import java.util.Arrays;

public class QuickSort {

    public static void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end)
            return;

        var boundary = partition(arr, start, end);

        quickSort(arr, start, boundary - 1);
        quickSort(arr, boundary + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        var pivot = arr[end];
        var boundary = start - 1;

        for (var i = start; i <= end; i++) {
            if (arr[i] <= pivot)
                swap(arr, i, ++boundary);
        }

        return boundary;
    }

    private static void swap(int[] arr, int one, int two) {
        var temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }
}
