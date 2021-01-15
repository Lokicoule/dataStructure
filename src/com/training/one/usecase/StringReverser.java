package com.training.one.usecase;

import java.util.Stack;

public class StringReverser {
    public String reverse(String input) {
        if (input == null)
            throw new IllegalArgumentException();

        Stack<Character> stack = new Stack<>();
        StringBuffer reversed = new StringBuffer();
        for (char c : input.toCharArray())
            stack.push(c);
        while (!stack.empty())
            reversed.append(stack.pop());
        return reversed.toString();
    }
}
