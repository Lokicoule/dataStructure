package com.training.sorting;

import java.util.Arrays;

public class Launcher {


    public static void main(String args[]) {
        var arr = new int[] {15, 15, 6, 3, 1, 22, 10, 13, 22};
        System.out.println(Arrays.toString(arr));
        System.out.println("----------");
        BucketSort.sort(arr, 22);
        System.out.println("----------");
        System.out.println(Arrays.toString(arr));
    }
}

