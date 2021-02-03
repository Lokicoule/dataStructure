package com.training.sorting;

public class Launcher {


    public static void main(String args[]) {
        var arr = new int[] {12, 4, 8, 9, 1};
        BubbleSort.sort(arr);
        for (var i : arr)
            System.out.println(i);
    }
}

