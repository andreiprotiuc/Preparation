package com.andrei.datastructures.hashtable;

/**
 * Hash Table implementation using linear probing (open addressing)
 *
 * @param <K> Object type that will be used as Key of the table
 * @param <V> Object type that will be used as the Value
 */
public class HashTable<K, V> {

    private int currentSize; // number of key-value pairs in the symbol table
    private int maxSize;     // size of linear probing table
    private K[] keys;        // the keys
    private V[] vals;        // the values


    public HashTable(int capacity) {
        this.maxSize = capacity;
        this.currentSize = 0;
        keys = (K[]) new Object[maxSize];
        vals = (V[]) new Object[maxSize];
    }

    /**
     * Inserts the specified key-value pair into hash table, overwriting the old
     * value with the new value if the hash table already contains the specified key.
     * Deletes the specified key (and its associated value) from this hash table
     * if the specified value is {@code null}.
     *
     * @param key   the key
     * @param value the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(K key, V value) {
        if (key == null) throw new IllegalArgumentException("Key is NULL");

        if (value == null) {
            remove(key);
        }

        if (currentSize >= maxSize / 2) resizeTable(maxSize * 2);

        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % maxSize) {
            if (keys[i].equals(key)) {
                vals[i] = value;
                return;
            }
        }

        keys[i] = key;
        vals[i] = value;
        currentSize++;
    }

    /**
     * Returns true if this symbol table contains the specified key.
     *
     * @param key the key
     * @return {@code true} if this symbol table contains {@code key};
     * {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public boolean contains(K key) {
        if (key == null) throw new IllegalArgumentException("Key argument is NULL");
        return get(key) != null;
    }


    /**
     * Returns the value associated with the specified key.
     *
     * @param key the key
     * @return the value associated with {@code key};
     * {@code null} if no such value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public V get(K key) {
        if (key == null) throw new IllegalArgumentException("Argument to get() is null");

        for (int i = hash(key); keys[i] != null; i = (i + 1) % maxSize) {
            if (keys[i].equals(key)) {
                return vals[i];
            }
        }

        return null;
    }

    /**
     * Removes the specified key and its associated value from this symbol table
     * (if the key is in this symbol table).
     *
     * @param key the key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void remove(K key) {
        if (key == null) throw new IllegalArgumentException("Argument to remove is NULL");
        if (!contains(key)) return;

        // find the position of the key
        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % maxSize;
        }

        // delete key and associated value
        keys[i] = null;
        vals[i] = null;

        // rehash all keys in same cluster
        i = (i + 1) % maxSize;
        while (keys[i] != null) {
            // delete keys[i] an vals[i] and reinsert
            K keyToRehash = keys[i];
            V valueToRehash = vals[i];
            keys[i] = null;
            vals[i] = null;
            currentSize--;
            put(keyToRehash, valueToRehash);
            i = (i + 1) % maxSize;
        }

        currentSize--;

        // halves size of array if it's 12.5% full or less
        if (currentSize > 0 && currentSize <= maxSize / 8) resizeTable(maxSize / 2);
    }

    // resize the hash table to the given capacity by re-hashing all of the keys
    private void resizeTable(int newSize) {
        HashTable<K, V> temp = new HashTable<>(newSize);
        for (int i = 0; i < maxSize; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], vals[i]);
            }
        }

        keys = temp.keys;
        vals = temp.vals;
        maxSize = temp.maxSize;
        currentSize = temp.currentSize;
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % maxSize;
    }
}
