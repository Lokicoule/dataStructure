package com.training.two.util.linear;

import java.util.LinkedList;

public class HashTable {
    private class Entry {
        private int key;
        private Object value;

        public Entry(int key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry> entries;

    public void HashTable(Object object) {
        entries = new LinkedList<>();
    }

    public void add(final int key, final Object value) {
        final Entry entry = new Entry(key, value);
        final int index = hash(key);
        if (entries. == null) {
            // instanciate linkedlist
        }
        // add element to linkedlist
        // table[index]
    }

    private int hash(final int key) {
        return key % entries.length;
    }
}
