package com.training.one.util.hashtable;

import java.util.LinkedList;

public class HashTable {
    private class Entry { // KeyValuePair
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }
    private LinkedList<Entry>[] entries = new LinkedList[5];

    public void put(final int key, final String value) {

        var entry = getEntry(key);
        if (entry != null) {
            entry.value = value;
            return;
        }

        getOrCreateBucket(key).addLast(new Entry(key, value));
    }

    public String get(final int key) {
        final var entry = getEntry(key);
        return (entry == null) ? null : entry.value;
    }

    public void remove(final int key) {
        final var entry = getEntry(key);
        if (entry == null)
            throw new IllegalStateException();
        getBucket(key).remove(entry);
    }

    private LinkedList<Entry> getBucket(final int key) {
        return entries[hash(key)];
    }

    private LinkedList<Entry> getOrCreateBucket(final int key) {
        final var index = hash(key);
        var bucket = entries[index];
        if (bucket == null)
            entries[index] = new LinkedList<>();

        return bucket;
    }

    private Entry getEntry(final int key) {
        var bucket = getBucket(key);
        if (bucket != null) {
            for (var entry : bucket) {
                if (entry.key == key)
                    return entry;
            }
        }
        return null;
    }

    private int hash(int key) {
        return key % entries.length;
    }
}
