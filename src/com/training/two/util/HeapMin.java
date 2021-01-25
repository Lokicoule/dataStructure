package com.training.two.util;

public class HeapMin {
    private class Node {
        private int key;
        private String value;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }
    private Node[] nodes = new Node[10];
    private int size;

    public void insert(int key, String value) {
        if (isFull())
            throw new IllegalStateException();

        nodes[size++] = new Node(key, value);

        bubbleUp();
    }

    public Node remove() {
        if (isEmpty())
            throw new IllegalStateException();

        var root = nodes[0];
        nodes[0] = nodes[--size];
        bubbleDown();

        return root;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == nodes.length;
    }

    private void bubbleUp() {
        var index = size - 1;
        System.out.println("---- nodes[index].key" + nodes[index].key);
        System.out.println(nodes[parentIndex(index)].key);
        while (index > 0 && nodes[index].key < nodes[parentIndex(index)].key) {
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }
    }

    private void bubbleDown() {
        var index = 0;
        while (index <= size && !isValidParent(index)) {
            var smallerChildIndex = smallerChildIndex(index);
            swap(index, smallerChildIndex);
            index = smallerChildIndex;
        }
    }

    private int smallerChildIndex(int index) {
        if (!hasLeftChild(index))
            return index;
        if (!hasRightChild(index))
            return leftChildIndex(index);

        return leftChild(index).key < rightChild(index).key
                ? leftChildIndex(index) : rightChildIndex(index);
    }

    private boolean isValidParent(int index) {
        if (!hasLeftChild(index))
            return true;
        
        var isValid = nodes[index].key <= leftChild(parentIndex(index)).key;

        if (hasRightChild(index))
            isValid &= nodes[index].key <= rightChild(parentIndex(index)).key;
        return isValid;
    }

    private Node parent(int index) {
        return nodes[parentIndex(index)];
    }

    private int parentIndex(int index) {
        return (index - 1) / 2;
    }
    
    private boolean hasLeftChild(int index) {
        return leftChildIndex(index) <= size;
    }

    private Node leftChild(int index) {
        return nodes[leftChildIndex(index)];
    }

    private int leftChildIndex(int index) {
        return index * 2 + 1;
    }
    
    private boolean hasRightChild(int index) {
        return rightChildIndex(index) <= size;
    }

    private Node rightChild(int index) {
        return nodes[rightChildIndex(index)];
    }

    private int rightChildIndex(int index) {
        return index * 2 + 2;
    }

    private void swap(int one, int two) {
        var temp = nodes[one];
        nodes[one] = nodes[two];
        nodes[two] = temp;
    }
}
