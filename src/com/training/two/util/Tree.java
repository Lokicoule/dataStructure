package com.training.two.util;

public class Tree {
    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node=" + value;
        }
    }
    private Node root;

    public void insert(int value) {
        var node = new Node(value);
        if (root == null) {
            root = node;
            return;
        }
        Node current = root;
        while (current != null) {
            if (value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            }
            else {
                if (current.rightChild == null) {
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }
        }
    }

    public boolean find(int value) {
        Node current = root;
        while (current != null) {
            if (current.value > value)
                current = current.leftChild;
            else if (current.value < value)
                current = current.rightChild;
            else
                return true;
        }
        return false;
    }

    public void breadthFirst() {
        breadthFirst(root);
    }

    private void breadthFirst(Node root) {
        System.out.println(root);
        var last = root;
        while (root != null) {
            if (root.leftChild != null)
                System.out.println(root.leftChild);
            if (root.rightChild != null)
                System.out.println(root.rightChild);
            var old = root;
            if (last.leftChild == root)
                root = last.rightChild;
            else
                root = last.leftChild;
            last = old;
        }
    }

    public void depthFirstPreOrder() {
       depthFirstPreOrder(root);
    }

    private void depthFirstPreOrder(Node root) {
        if (root == null)
            return;
        System.out.println(root);
        depthFirstPreOrder(root.leftChild);
        depthFirstPreOrder(root.rightChild);
    }

    public void depthFirstInOrder() {
        depthFirstInOrder(root);
    }

    private void depthFirstInOrder(Node root) {
        if (root == null)
            return;
        depthFirstPreOrder(root.leftChild);
        System.out.println(root);
        depthFirstPreOrder(root.rightChild);
    }

    public void depthFirstPostOrder() {
        depthFirstPostOrder(root);
    }

    private void depthFirstPostOrder(Node root) {
        if (root == null)
            return;
        depthFirstPreOrder(root.leftChild);
        depthFirstPreOrder(root.rightChild);
        System.out.println(root);
    }

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if (root == null)
            return -1;

        if (root.leftChild == null && root.rightChild == null) return 0;
        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }
}
