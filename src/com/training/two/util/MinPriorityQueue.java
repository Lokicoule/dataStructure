package com.training.two.util;

public class MinPriorityQueue {
    private HeapMin heap = new HeapMin();

    public void insert(String value, int priority) {
        heap.insert(priority, value);
    }

    public String remove() {
        return heap.remove();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }
}
