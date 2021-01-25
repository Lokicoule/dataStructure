package com.training.one.util.queue;

import java.util.Arrays;
// O(n) - insertion
// 0(1) - deletion
public class PriorityQueue {
    int[] items;
    int count;

    public PriorityQueue(int capacity) {
        this.items = new int[capacity];
    }

    public void add(int item) {
        if (isFull()) throw new IllegalStateException();
        int i = shift(item);
        items[i] = item;
        count++;
    }

    public int remove() {
        if (isEmpty())
            throw new IllegalStateException();
        return items[--count];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == items.length;
    }

    private int shift(int item) {
        int i;
        for (i = count - 1; i >= 0; i--) {
            if (items[i] > item)
                items[i + 1] = items[i];
            else
                break;
        }
        return i + 1;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
