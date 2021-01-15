package com.training.one.util.queue;

import java.util.ArrayList;

public class LinkedListQueue {
    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
    private Node head;
    private Node tail;
    private int count;

    public void enqueue(int item) {
        var node = new Node(item);
        if (isEmpty())
            head = tail = node;
        else {
            tail.next = node;
            tail = node;
        }
        count++;
    }

    public int dequeue() {
        if (isEmpty()) throw new IllegalStateException();

        int value = head.value;
        if (head == tail) head = tail = null;
        else {
            var second = head.next;
            head.next = null; // for GC
            head = second;
        }
        count--;
        return value;
    }

    public int peek() {
        if (isEmpty()) throw new IllegalStateException();
        return head.value;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        ArrayList<Integer> list = new ArrayList<>();
        Node iterator = head;
        while (iterator != null) {
            list.add(iterator.value);
            iterator = iterator.next;
        }
        return list.toString();
    }
}
