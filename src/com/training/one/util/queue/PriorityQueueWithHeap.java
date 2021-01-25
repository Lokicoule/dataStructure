package com.training.one.util.queue;

import com.training.two.util.Heap;

// O(log n) insertion
// O (log n) deletion
public class PriorityQueueWithHeap {
    private Heap heap = new Heap();

    public void insert(int item) {
        heap.insert(item);
    }

    public int remove() {
        return heap.remove();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }
}
