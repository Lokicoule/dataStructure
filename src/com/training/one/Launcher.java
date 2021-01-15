package com.training.one;

import com.training.one.usecase.HashTableExercices;
import com.training.one.usecase.QueueReverser;
import com.training.one.usecase.StringReverser;
import com.training.one.util.array.Array;
import com.training.one.usecase.Expression;
import com.training.one.util.linkedlist.LinkedList;
import com.training.one.util.queue.ArrayQueue;
import com.training.one.util.queue.LinkedListQueue;
import com.training.one.util.queue.PriorityQueue;
import com.training.one.util.queue.TwoStackQueue;
import com.training.one.util.stack.MinStack;
import com.training.one.util.stack.Stack;
import com.training.one.util.stack.StackWithTwoQueues;
import com.training.one.util.stack.TwoStacks;

import java.util.*;

public class Launcher {

    private static void setupArray() {
        Array numbers = new Array(2);
        numbers.insert(100);
        numbers.insert(2);
        numbers.insert(3);
        numbers.insert(39);
        numbers.insertAt(99, 2);
        //numbers.reverse();
        //res.print();
        numbers.print();
    }

    private static void setupLinkedList() {
        LinkedList list = LinkedList.createWithLoop();
        System.out.println("size:" + list.size());
        //System.out.println(list.hasLoop());
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);
        list.addLast(60);
        //list.removeFirst();
        //list.removeLast();

        //list.printFirst();
        //list.addLast(9);
        //list.printLast();
        //list.reverse();
        //System.out.println(list.getKthFromTheEnd(1));
        System.out.println("size:" + list.size());
        list.printMiddle();
        int[] array = list.toArray();
        System.out.println(Arrays.toString(array));
        System.out.println(list.hasLoop());
    }

    private static void setupStringReverser() {
        String str = "abcd";
        StringReverser stringReverser = new StringReverser();
        String result = stringReverser.reverse(str);
        System.out.println(result);
    }

    private static void setupExpression() {
        Expression exp = new Expression();
        System.out.println(exp.isBalanced("(1 + 2)"));
        System.out.println(exp.isBalanced("((1 + 2)"));
        System.out.println(exp.isBalanced("(1 + 2))"));
        System.out.println(exp.isBalanced("(1 + 2"));
    }

    private static void setupStack() {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.pop());
        System.out.println("peek : " + stack.peek());
        System.out.println(stack);
    }

    private static void setupTwoStacks() {
        TwoStacks stack = new TwoStacks(5);
        stack.push1(101);
        stack.push1(102);
        stack.push1(103);
        stack.push2(201);
        //stack.push1(103);

        stack.push2(202);
        System.out.println(stack);
        System.out.println(stack.pop1());
        System.out.println(stack.pop2());
        System.out.println(stack);
    }

    private static void setupMinStack() {
        MinStack stack = new MinStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(1);
        System.out.println(stack.pop());
        System.out.println(stack.min());
    }

    private static void setupQueueReverse() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        reverse(queue);
        System.out.println(queue);
    }

    private static void setupQueue() {
        ArrayQueue queue = new ArrayQueue(5);
        System.out.println(queue.isEmpty());

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(50);
        queue.enqueue(50);

        System.out.println(queue);
        System.out.println(queue.isFull());
        System.out.println(queue.isEmpty());
    }

    private static void reverse(Queue<Integer> queue) {
        if (queue.isEmpty()) throw new IllegalStateException();

        Stack stack = new Stack();
        while (!queue.isEmpty())
            stack.push(queue.remove());
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }

    private static void setupTwoStackQueue() {
        TwoStackQueue queue = new TwoStackQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        System.out.println(queue.dequeue());

        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        //System.out.println(queue.dequeue());

        System.out.println(queue);
    }

    private static void setupPriorityQueue() {
        PriorityQueue queue = new PriorityQueue(10);

        queue.add(10);
        System.out.println(queue);//[10]
        queue.add(7);
        System.out.println(queue);//[7;10]
        queue.add(11);
        System.out.println(queue);//[7;10;11]
        queue.add(2);
        System.out.println(queue);//[2;7;10;11]
        System.out.println(queue.remove());

        queue.add(12);
        queue.add(22);
        queue.add(32);
        queue.add(42);
        queue.add(52);
        System.out.println(queue);//[2;7;10;11]
    }

    private static void setupQueueReverser() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        System.out.println(queue);
        QueueReverser.reverse(queue, 3);
        System.out.println(queue);
    }

    private static void setupLinkedListQueue() {
        LinkedListQueue queue = new LinkedListQueue();
        queue.enqueue(1);
        queue.dequeue();
        queue.enqueue(2);
        queue.enqueue(3);
        queue.dequeue();
        queue.enqueue(4);
        queue.dequeue();
        queue.enqueue(5);
        queue.enqueue(6);
        System.out.println(queue);
    }
    private static void setupStackWithTwoQueues() {
        StackWithTwoQueues stack = new StackWithTwoQueues();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.peek());
    }
    public static void main(String args[]) {
       // System.out.println(CharFinder.findFistNonRepeatedChar("a green pineapple"));
        // System.out.println(CharFinder.findFirstRepeatedChar("azerty"));
        /*HashTable hashTable = new HashTable();
        hashTable.put(10, "toto");
        hashTable.put(1, "toto1");
        hashTable.put(2, "toto2");
        System.out.println(hashTable.get(10));

        hashTable.put(10, "toto01");

        System.out.println(hashTable);*/
    //    System.out.println(HashTableExercices.mostFrequent(new int[]{1,2,2,3,3,3,4}));
      //  System.out.println(HashTableExercices.countPairsWithDiff(new int[]{1, 7, 5, 9, 2, 12, 3}, 2));
        //System.out.println(HashTableExercices.countPairsWithDiff(new int[]{1, 2, 12, 7, 9, 4, 3}, 2));
       var res=HashTableExercices.twoSum(new int[]{2,8, 11, 15, 7}, 9);
        for (var nb : res) System.out.println(nb);
    }
}

