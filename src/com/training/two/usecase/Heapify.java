package com.training.two.usecase;

import com.training.two.util.Heap;

import java.util.Arrays;

public class Heapify {
    public static void heapify(int[] array) {
        var lastParentIdx = array.length / 2 - 1;
        for (var i = lastParentIdx; i >= 0; i--)
            heapify(array, i);
    }

    private static void heapify(int[] array, int idx) {
        var largerIdx = idx;
        var left = 2 * idx + 1;
        var right = left + 1;

        if (left < array.length
                && array[largerIdx] < array[left])
            largerIdx = left;
        if (right < array.length
                && array[largerIdx] < array[right])
            largerIdx = right;

        if (idx == largerIdx)
            return;

        swap(array, idx, largerIdx);
        heapify(array, largerIdx);
    }

    public static int getKthLargest(int[] numbers, int k) {
        if (k < 1 || k > numbers.length)
            throw new IllegalArgumentException();

        var heap = new Heap();
        for (var nb : numbers)
            heap.insert(nb);
        for (var i = 0; i < k - 1; i++)
            heap.remove();
        return heap.max();
    }

    private static void swap(int[] array, int idxOne, int idxTwo) {
        var temp = array[idxOne];
        array[idxOne] = array[idxTwo];
        array[idxTwo] = temp;
    }
}
