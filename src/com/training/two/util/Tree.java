package com.training.two.util;

import java.util.ArrayList;

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

    //TraverseLevelOrder
    private void breadthFirst(Node root) {
        if (root != null)
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
    //BreadthFirst other implementation
    public void traverseLevelOrder() {
        for (var i = 0; i <= height(); i++) {
            for (var value : kthDistance(i)) {
                System.out.println(value);
            }
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
        depthFirstInOrder(root.leftChild);
        System.out.println(root);
        depthFirstInOrder(root.rightChild);
    }

    public void depthFirstPostOrder() {
        depthFirstPostOrder(root);
    }

    private void depthFirstPostOrder(Node root) {
        if (root == null)
            return;
        depthFirstPostOrder(root.leftChild);
        depthFirstPostOrder(root.rightChild);
        System.out.println(root);
    }

    private boolean isLeaf(Node node) {
        return node.leftChild == null && node.rightChild == null;
    }

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if (root == null)
            return -1;

        if (isLeaf(root)) return 0;
        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    //O(Log N)
    public int min() {
        var current = root;
        var last = current;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last.value;
    }

    //O(N)
    private int min(Node root) {
        if (isLeaf(root))
            return root.value;

        var left = min(root.leftChild);
        var right = min(root.rightChild);

        return Math.min(Math.min(left, right), root.value);
    }

    public boolean equals(Tree other) {
        if (other == null)
            return false;

        return equals(root, other.root);
    }

    private boolean equals(Node one, Node two) {
        if (one == null && two == null)
            return true;
        if (one != null && two != null)
            return one.value == two.value
                    && equals(one.leftChild, two.leftChild)
                    && equals(one.rightChild, two.rightChild);
        return false;
    }

    public void swapRoot() {
        var temp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = temp;
    }

    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinarySearchTree(Node current, int min, int max) {
        if (current == null) return true;

        if (current.value < min || current.value > max)
            return false;

        return isBinarySearchTree(current.leftChild, min, current.value + 1)
                && isBinarySearchTree(current.rightChild, current.value + 1, max);
    }

    public ArrayList<Node> kthDistance(int distance) {
         return kthDistance(root, distance);
    }

    //differente version par mosh
    //store dans 3° args list
    private ArrayList<Node> kthDistance(Node root, int distance) {
        ArrayList<Node> nodes = new ArrayList<>();
        if (root == null) return nodes;
        if (distance == 0) {
            nodes.add(root);
            return nodes;
        }
        nodes.addAll(kthDistance(root.leftChild, distance - 1));
        nodes.addAll(kthDistance(root.rightChild, distance - 1));
        return nodes;
    }

    public int size() {
        return size(root);
    }

    private int size(Node root) {
        if (root == null) return 0;

        if (isLeaf(root)) return 1;

        return 1 + size(root.leftChild)
                + size(root.rightChild);
    }

    public int countLeaves() {
        return countLeaves(root);
    }

    private int countLeaves(Node root) {
        if (root == null) return 0;

        if (isLeaf(root)) return 1;

        return countLeaves(root.leftChild)
                + countLeaves(root.rightChild);
    }

    public int max() {
        if (root == null) throw new IllegalStateException();

        return max(root);
    }

    private int max(Node root) {
        if (root.rightChild == null)
            return root.value;
        return max(root.rightChild);
    }

    public boolean contains(int value) {
        return contains(root, value);
    }

    private boolean contains(Node root, int value) {
        if (root == null)
            return false;
        if (root.value == value)
            return true;
        return contains(root.leftChild, value)
                || contains(root.rightChild, value);
    }

    public boolean areSibling(int one, int two) {
        return areSibling(root, one, two);
    }

    private boolean areSibling(Node root, int one, int two) {
        if (root == null)
            return false;
        boolean areSibling = false;
        if (root.leftChild != null && root.rightChild != null)
            areSibling = (root.leftChild.value == one &&  root.rightChild.value == two)
                || (root.leftChild.value == two &&  root.rightChild.value == one);
        return areSibling || areSibling(root.leftChild, one, two) || areSibling(root.rightChild, one, two);
    }

    public void getAncestor() {

    }

    public void isBalanced() {

    }

    public void isPerfect() {

    }
}
