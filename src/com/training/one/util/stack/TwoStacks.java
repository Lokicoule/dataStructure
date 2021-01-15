package com.training.one.util.stack;

import java.util.Arrays;

public class TwoStacks {
    int[] items;
    int countLeft;
    int countRight;

    public TwoStacks(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException("capacity must be 1 or greater.");

        items = new int[capacity];
        countLeft = 0;
        countRight = capacity;
    }

    public void push1(int item) {
        if (isFull1())
            throw new StackOverflowError();

        items[countLeft++] = item;
    }

    public void push2(int item) {
        if (isFull2())
            throw new StackOverflowError();

        items[--countRight] = item;
    }

    public int pop1() {
        if (isEmpty1())
            throw new IllegalStateException();

        return items[--countLeft];
    }

    public int pop2() {
        if (isEmpty2())
            throw new IllegalStateException();

        return items[countRight++];
    }

    public boolean isEmpty1() {
        return countLeft == 0;
    }

    public boolean isEmpty2() {
        return countRight == items.length;
    }

    public boolean isFull1() {
        return isFull();
    }

    public boolean isFull2() {
        return isFull();
    }

    private boolean isFull() {
        return countRight == countLeft;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
