package com.training.two.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Trie {

    private class Node {
        private char value;
        private HashMap<Character, Node> children = new HashMap<>();
        private boolean isEndOfWord;

        public Node(char value) {
            this.value = value;
        }

        public boolean hasChild(char ch) {
            return children.containsKey(ch);
        }

        public void addChild(char ch) {
            children.put(ch, new Node(ch));
        }

        public Node getChild(char ch) {
            return children.get(ch);
        }
        
        public void removeChild(char ch) {
            children.remove(ch);
        }

        public Node[] getChildren() {
            return children.values().toArray(new Node[0]);
        }

        public boolean hasChildren() {
            return !children.isEmpty();
        }

        @Override
        public String toString() {
            return "value=" + value;
        }
    }

    private Node root = new Node(' ');

    public void insert(String word) {
        if (word == null)
            throw new IllegalArgumentException();

        var current = root;
        for (var ch : word.toLowerCase().toCharArray()) {
            if (!current.hasChild(ch)) {
                current.addChild(ch);
            }
            current = current.getChild(ch);
        }
        current.isEndOfWord = true;
    }

    public void remove(String word) {
        if (word == null)
            return;

        remove(root, word, 0);
    }

    private void remove(Node root, String word, int index) {
        if (index == word.length()) {
            root.isEndOfWord = false;
            return;
        }
        var ch = word.charAt(index);
        var child = root.getChild(ch);
        if (child == null) return;

        remove(child, word, index + 1);
        if (!child.hasChildren() && !child.isEndOfWord)
            root.removeChild(ch);
    }

    public boolean contains(String word) {
        if (word == null || word.length() == 0)
            return false;

        var current = root;
        for (var ch : word.toLowerCase().toCharArray()) {
            if (!current.hasChild(ch))
                return false;

            current = current.getChild(ch);
        }
        return current.isEndOfWord;
    }

    public List<String> findWords(String prefix) {
        List<String> result = new ArrayList<>();
        Node lastNode = findLastNodeOf(prefix);
        findWords(lastNode, prefix, result);
        return result;
    }

    private Node findLastNodeOf(String prefix) {
        if (prefix == null)
            return null;

        var current = root;
        for (var ch : prefix.toLowerCase().toCharArray()) {
            var child = current.getChild(ch);
            if (child == null)
                return null;
            current = child;
        }
        return current;
    }

    private void findWords(Node root, String word,  List<String> words) {
        if (root == null)
            return;

        if(root.isEndOfWord)
            words.add(word);

        for (var child : root.getChildren())
            findWords(child, word + child.value, words);
    }

    public void traverse() {
        traverse(root);
    }

    private void traverse(Node root) {
        System.out.println(root);

        for(var node : root.getChildren())
            traverse(node);
    }

    public boolean containsRecursive(String word) {
        return containsRecursive(root, word, 0);
    }

    private boolean containsRecursive(Node root, String word, int index) {
        if (index == word.length() - 1) {
            return root.isEndOfWord;
        }
        if (root == null)
            return false;

        var ch = word.charAt(index);
        var child = root.getChild(ch);
        if (child == null)
            return false;

        return containsRecursive(child, word, index + 1);
    }

    public int countWords() {
        return countWords(root);
    }

    private int countWords(Node root) {
        var total = 0;
        if (root.isEndOfWord)
            total++;

        for (var child : root.getChildren())
            total += countWords(child);

        return total;
    }

    public static String longestCommonPrefix(String[] words) {
        if (words == null)
            return null;

        var trie = new Trie();
        for (var word : words)
            trie.insert(word);

        var prefix = new StringBuffer();
        var maxChars = getShortest(words).length();
        var current = trie.root;

        while (prefix.length() < maxChars) {
            var children = current.getChildren();
            if (children.length != 1)
                break;
            current = children[0];
            prefix.append(current.value);
        }

        return prefix.toString();
    }

    private static String getShortest(String[] words) {
        if (words == null || words.length == 0)
            return "";

        var shortest = words[0];
        for (var word : words) {
            if (shortest.length() > word.length())
                shortest = word;
        }

        return shortest;
    }

}
