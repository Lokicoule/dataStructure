package com.training.searching;

import com.training.one.util.array.Array;

import java.util.Arrays;

public class BinarySearch {

    public static int search(int[] arr, int target) {
        int left = 0, right =  arr.length - 1;

        while (left <= right) {
            var middle = (left + right) / 2;
            if (arr[middle] == target)
                return middle;
            if (target < arr[middle])
                right = middle - 1;
            else
                left = middle + 1;
        }
        return -1;
    }

    public static int searchRec(int[] arr, int target) {
        return search(arr, 0, arr.length - 1, target);
    }

    private static int search(int[] arr, int left, int right, int target) {
        if (right < left)
            return -1;

        var middle = (left + right) / 2;

        if (arr[middle] > target)
            return search(arr, left, middle - 1, target);
        else if (arr[middle] < target)
            return search(arr, middle + 1, right, target);
        return middle;
    }

}
