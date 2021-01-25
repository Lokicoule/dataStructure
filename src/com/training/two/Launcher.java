package com.training.two;

import com.training.two.usecase.Heapify;
import com.training.two.util.AVLTree;
import com.training.two.util.Heap;
import com.training.two.util.HeapMin;
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

    private static void avltree() {
        AVLTree tree = new AVLTree();
        tree.insert(30);
        tree.insert(20);
        tree.insert(10);
        System.out.println(tree);
    }

    private static void setupHeap() {
        Heap heap = new Heap();
        heap.insert(10);
        heap.insert(20);
        heap.insert(30);
        heap.insert(40);
        heap.print();
        heap.remove();
        heap.insert(10000);
        System.out.println("-----");
        heap.print();
    }

    public static void main(String args[]) {
        int [] numbers = {5, 3, 8, 4, 1, 2};
        System.out.println(Heapify.getKthLargest(numbers, 6));
        //Heapify.heapify(numbers);
        System.out.println(Heap.isMaxHeap(numbers));

        HeapMin heap = new HeapMin();
        heap.insert(12, "douze");
        heap.insert(10, "dix");
        heap.insert(8, "huit");
        heap.remove();
        heap.insert(20, "huit");

    }
}

