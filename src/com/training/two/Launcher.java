package com.training.two;

import com.training.two.util.AVLTree;
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
        AVLTree tree = new AVLTree();
        tree.insert(30);
        tree.insert(20);
        tree.insert(10);
        System.out.println(tree);
    }
}

