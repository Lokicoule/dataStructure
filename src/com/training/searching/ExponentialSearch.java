package com.training.searching;

public class ExponentialSearch {

    public static int search(int[] arr, int target) {
        int blockSize = (int) Math.sqrt(arr.length);
        int start = 0;
        int next = blockSize;
        while (start < arr.length
                && arr[next - 1] < target) {
            start = next;
            next += blockSize;
            if (next > arr.length)
                next = arr.length;
        }

        for (var i = 0; i < next; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }
}
