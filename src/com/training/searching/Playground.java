package com.training.searching;

public class Playground {
    public static int search(int[] arr, int target) {
        return search(arr, target, 0, arr.length - 1);
    }

    private static int search(int[] arr, int target, int left, int right) {
        if (right < left)
            return -1;
        var middle = (left + right) / 2;
        if (arr[middle] == target)
            return middle;
        else if (arr[middle] > target)
            return search(arr, target, left, middle - 1);
        return search(arr, target, middle + 1, right);
    }
}
