package com.training.sorting;

import java.util.Arrays;

public class QuickSort {

    public static void sort(int[] arr) {
        if (arr.length == 1)
            return;

        var middleIdx = arr.length / 2;
        var left = Arrays.copyOfRange(arr, 0, middleIdx);
        var right = Arrays.copyOfRange(arr, middleIdx, arr.length);

        sort(left);
        sort(right);

        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else
                arr[k++] = right[j++];
        }
        while (i < left.length)
            arr[k++] = left[i++];
        while (j < right.length)
            arr[k++] = right[j++];
    }
}
