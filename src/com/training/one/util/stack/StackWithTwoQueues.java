package com.training.one.util.stack;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackWithTwoQueues {
    private Queue<Integer> queueOne = new ArrayDeque<>();
    private Queue<Integer> queueTwo = new ArrayDeque<>();
    private int top;
    public void push(int item) {
        queueOne.add(item);
        top = item;
    }

    public int pop() {
        if (isEmpty()) throw new IllegalStateException();

        while (queueOne.size() > 1) {
            top = queueOne.remove();
            queueTwo.add(top);
        }
        swapQueues();

        return queueTwo.remove();
    }

    public int peek() {
        if (isEmpty()) throw new IllegalStateException();
        return top;
    }

    public int size() {
        return queueOne.size();
    }

    public boolean isEmpty() {
        return queueOne.isEmpty();
    }

    private void swapQueues() {
        var temp = queueOne;
        queueOne = queueTwo;
        queueTwo = temp;
    }
}
