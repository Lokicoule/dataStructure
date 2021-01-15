package com.training.one.usecase;

import com.training.one.util.stack.Stack;

import java.util.Queue;

public class QueueReverser {

    public static void reverse(Queue<Integer> queue, int k) {
        if (k < 0 || k > queue.size())
            throw new IllegalArgumentException();

        Stack stack = new Stack();
        for (int i = 0; i < k; i++)
            stack.push(queue.remove());
        while (!stack.isEmpty())
            queue.add(stack.pop());
        while (k++ < queue.size())
            queue.add(queue.remove());
    }
}
