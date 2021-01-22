package com.training.two;

import com.training.two.util.Tree;

public class Launcher {

    private static int factorial(int nb) {
        if (nb == 0) return 1;
        return nb * factorial(nb - 1);
    }

    private static int fib(int nb) {
        System.out.println(nb);
        if (nb < 2) return nb;
        return (fib(nb - 1) + fib(nb - 2));
    }

    public static void main(String args[]) {
        Tree tree = new Tree();
        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);
        //System.out.println(tree.find(9));
        //System.out.println(tree.find(17));
        //System.out.println(tree);
        //ree.breadthFirst();
        //System.out.println(factorial(4));
        //tree.depthFirstPreOrder();
        //tree.depthFirstInOrder();
        //tree.depthFirstPostOrder();
        //System.out.println(fib(6));

        System.out.println(tree.kthDistance(3));
    }
}

