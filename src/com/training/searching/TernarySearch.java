package com.training.searching;

public class TernarySearch {

    public static int search(int[] arr, int target) {
        return search(arr, target, 0, arr.length - 1);
    }

    private static int search(int[] arr, int target, int left, int right) {
        if (right < left)
            return -1;

        var partitionSize = (right - left) / 3;
        var middleOne = left + partitionSize;
        var middleTwo = right - partitionSize;

        if (arr[middleOne] == target)
            return middleOne;
        if (arr[middleTwo] == target)
            return middleTwo;

        if (target < arr[middleOne])
            return search(arr, target, left, middleOne - 1);
        if (target > arr[middleTwo])
            return search(arr, target, middleTwo + 1, right);
        return search(arr, target, middleOne + 1, middleTwo - 1);
    }
}
