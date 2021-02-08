package com.training.searching;


import com.training.sorting.QuickSort;

import java.util.Arrays;

public class Launcher {


    public static void main(String args[]) {
        var arr = new int[] {15, 15, 6, 3, 1, 22, 10, 13, 22};
        QuickSort.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("----------");
        var idx = JumpSearch.search(arr, 10);
        System.out.println("----------");
        System.out.println(idx);
    }
}

