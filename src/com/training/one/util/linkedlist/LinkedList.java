package com.training.one.util.linkedlist;

import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }
    private Node first;
    private Node last;
    private int size;

    public void addFirst(int item) {
        Node node = new Node(item);
        if (isEmpty())
            first = last = node;
        else {
            node.next = first;
            first = node;
        }
        size++;
    }

    public void addLast(int item) {
        Node node = new Node(item);
        if (isEmpty())
            first = last = node;
        else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public int indexOf(int item) {
        int index = 0;
        Node iterator = first;
        while (iterator != null) {
            if (iterator.value == item)
                return index;
            iterator = iterator.next;
            index++;
        }
        return -1;
    }

    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    public void removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();
        if (first == last) first = last = null;
        else {
            first = first.next;
        }
        size--;
    }

    public void removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();
        if (first == last) first = last = null;
        else {
            last = getPrevious(last);
            last.next = null;
        }
        size--;
    }

    public int size() {
        return size;
    }

    public int[] toArray() {
        int[] array = new int[size];
        int i = 0;

        Node iterator = first;
        while (iterator != null) {
            array[i++] = iterator.value;
            iterator = iterator.next;
        }
        return array;
    }

    /*TODO REFAIRE*/
    public void reverse() {
        if (isEmpty()) return;
        Node previous = first;
        Node current = first.next;
        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        last = first;
        last.next = null;
        first = previous;
    }

    public int getKthFromTheEnd(int k) {
        if (isEmpty())
            throw new IllegalStateException();
        Node iterator = first;
        Node cursor = first;
        for (int i = 0; i < k; i++) {
            cursor = cursor.next;
            // if size field doesnt exist check here
            if (cursor == null)
                throw new IllegalArgumentException();
        }
        while (cursor != null) {
            iterator = iterator.next;
            cursor = cursor.next;
        }
        return iterator.value;
    }

    public boolean hasLoop() {
        Node slow = first;
        Node fast = first;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public void printMiddle() {
        if (isEmpty())
            throw new IllegalStateException();
        Node iterator = first;
        Node middle = first;
        while (iterator != last && iterator.next != last) {
            iterator = iterator.next.next;
            middle = middle.next;
        }
        if (iterator == last)
            System.out.println("Middle : " + middle.value);
        else
            System.out.println("Middle : " + middle.value + ", " + middle.next.value);
    }

    private Node getPrevious(Node node) {
        Node iterator = first;
        while (iterator != null) {
            if (iterator.next == node) return iterator;
            iterator = iterator.next;
        }
        return null;
    }

    private boolean isEmpty() {
        return first == null;
    }


    public static LinkedList createWithLoop() {
        var list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        // Get a reference to 30
        var node = list.last;

        list.addLast(40);
        list.addLast(50);

        // Create the loop
        list.last.next = node;

        return list;
    }
}
