package com.training.one.util.queue;

import com.training.one.util.stack.Stack;

public class TwoStackQueue {
    private Stack stack1 = new Stack();
    private Stack stack2 = new Stack();

    public void enqueue(int item) {
        stack1.push(item);
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();
        moveStackOneToStackTwo();
        return stack2.pop();
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();
        moveStackOneToStackTwo();
        return stack2.peek();
    }

    private void moveStackOneToStackTwo() {
        if (stack2.isEmpty())
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    @Override
    public String toString() {
        return "TwoStackQueue{" +
                "stack1=" + stack1 +
                ", stack2=" + stack2 +
                '}';
    }
}
