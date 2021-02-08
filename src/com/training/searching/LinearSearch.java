package com.training.searching;

public class LinearSearch {

    static int search(int[] arr, int target) {
        for (var i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }
}
