package com.training.two.util;

public class Heap {
    private int[] items = new int[10];
    private int size;

    public void insert(int item) {
        if (isFull())
            throw new IllegalStateException();

        items[size++] = item;
        bubbleUp();
    }

    //remove root
    public int remove() {
        if (isEmpty())
            throw new IllegalStateException();

        var root = items[0];
        items[0] = items[--size];

        bubbleDown();

        return root;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void print() {
        for (var i = 0; i < size; i++) {
            System.out.println(items[i]);
        }
    }

    private int largerChildIndex(int idx) {
        if (!hasLeftChild(idx))
            return idx;
        if (!hasRightChild(idx))
            return leftChildIdx(idx);

        return (leftChild(idx) > rightChild(idx))
                ? leftChildIdx(idx) : rightChildIdx(idx);
    }

    private boolean hasLeftChild(int idx) {
        return leftChildIdx(idx) <= size;
    }

    private boolean hasRightChild(int idx) {
        return rightChildIdx(idx) <= size;
    }

    private boolean isValidParent(int idx) {
        if (!hasLeftChild(idx))
            return true;

        var isValid = items[idx] >= leftChild(idx);

        if (hasRightChild(idx))
            isValid &= items[idx] >= rightChild(idx);

        return isValid;
    }

    private int leftChild(int idx) {
        return items[leftChildIdx(idx)];
    }

    private int rightChild(int idx) {
        return items[rightChildIdx(idx)];
    }

    private void swap(int idxTarget, int idxSource) {
        var temp = items[idxTarget];
        items[idxTarget] = items[idxSource];
        items[idxSource] = temp;
    }

    private void bubbleUp() {
        var idx = size - 1;
        while (idx > 0 && items[idx] > items[parent(idx)]) {
            swap(idx, parent(idx));
            idx = parent(idx);
        }
    }

    private void bubbleDown() {
        var idx = 0;
        while(idx <= size && !isValidParent(idx)) {
            var largerChildIndex = largerChildIndex(idx);
            swap(idx, largerChildIndex);
            idx = largerChildIndex;
        }
    }

    private int leftChildIdx(int idx) {
        return 2 * idx + 1;
    }

    private int rightChildIdx(int idx) {
        return leftChildIdx(idx) + 1;
    }

    private int parent(int idx) {
        return (idx - 1) / 2;
    }

    private boolean isFull() {
        return size == items.length;
    }

    public int max() {
        if (isEmpty())
            throw new IllegalStateException();
        return items[0];
    }

    public static boolean isMaxHeap(int[] array) {
        return isMaxHeap(array, 0);
    }

    private static boolean isMaxHeap(int[] array, int index) {
        var parent = (index - 1) / 2;
        if (parent < index)
            return true;
        var left = parent * 2 + 1;
        var right = left + 1;

        var isValidParent = array[left] < array[parent]
                && array[right] < array[parent];

        return isValidParent && isMaxHeap(array, left) && isMaxHeap(array, right);
    }
}
