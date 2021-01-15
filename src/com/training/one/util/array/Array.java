package com.training.one.util.array;

public class Array {
    private int[] items;
    private int count;

    public Array(int length) {
        items = new int[length];
    }

    public void insert(int item) {
        resizeIfRequired();
        items[count++] = item;
    }

    private void resizeIfRequired() {
        if (count == items.length) {
            int[] newItems = new int[items.length * 2];
            for (int i = 0; i < items.length; i++)
                newItems[i] = items[i];
            items = newItems;
        }
    }

    public void removeAt(int index) {
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();
        for (int i = index; i < items.length - 1; i++) {
            items[i] = items[i + 1];
        }
        count--;
    }

    public int indexOf(int item) {
        for (int i = 0; i < count; i++)
            if (item == items[i])
                return i;
        return -1;
    }

    public int max() {
        int max = -1;
        for (int i = 0; i < count; i++) {
            if (items[i] > max)
                max = items[i];
        }
        return max;
    }

    public Array intersect(Array other) {
        Array intersection = new Array(count);
        for (int item : items) {
            if (other.indexOf(item) >= 0)
                intersection.insert(item);
        }
        return intersection;
    }

    public void reverse() {
        int[] reversedItems = new int[count];
        for (int i = count - 1; i >= 0; i--) {
            reversedItems[count - i - 1] = items[i];
        }
        items = reversedItems;
    }

    public void insertAt(int item, int index) {
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();
        resizeIfRequired();
        for (int i = count - 1; i >= index; i--) {
            items[i + 1] = items[i];
        }
        items[index] = item;
        count++;
    }

    public void print() {
        for (int i = 0; i < count; i++)
            System.out.println(items[i]);
    }

    public int get(int index) {
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();
        return items[index];
    }
}
