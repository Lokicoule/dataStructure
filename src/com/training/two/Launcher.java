package com.training.two;

import com.training.two.usecase.Heapify;
import com.training.two.util.*;

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
        var graph = new WeightedGraph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addEdge("A", "B", 3);
        graph.addEdge("B", "C", 2);
        graph.addEdge("A", "C", 10);
        graph.print();
        System.out.println(graph.getShortestPath("A", "C"));
    }
}

