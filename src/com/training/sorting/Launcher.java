package com.training.sorting;

import java.util.Arrays;

public class Launcher {


    public static void main(String args[]) {
        var arr = new int[] {8, 2, 4, 1, 3};
        System.out.println(Arrays.toString(arr));
        System.out.println("----------");
        InsertionSort.sort(arr);
        System.out.println("----------");
        System.out.println(Arrays.toString(arr));
    }
}

