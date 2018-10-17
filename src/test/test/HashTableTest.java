package test;

import com.andrei.datastructures.hashtable.HashTable;
import org.junit.Assert;
import org.junit.Test;

public class HashTableTest {

    @Test
    public void testPut() {
        HashTable<Integer, String>  hashTable = new HashTable<>(10);
        hashTable.put(1, "One");
        hashTable.put(2, "Two");
        Assert.assertEquals(hashTable.get(1), "One");
        Assert.assertEquals(hashTable.get(2), "Two");
    }

    @Test
    public void testContains() {
        HashTable<Integer, String>  hashTable = new HashTable<>(10);
        hashTable.put(1, "One");
        hashTable.put(2, "Two");
        Assert.assertTrue(hashTable.contains(1));
        Assert.assertTrue(hashTable.contains(2));
        Assert.assertFalse(hashTable.contains(3));
    }

    @Test
    public void testGet() {
        HashTable<Integer, String>  hashTable = new HashTable<>(10);
        hashTable.put(1, "One");
        hashTable.put(2, "Two");
        Assert.assertEquals(hashTable.get(1), "One");
        Assert.assertEquals(hashTable.get(2), "Two");
        Assert.assertNull(hashTable.get(3));
    }

    @Test
    public void testRemove() {
        HashTable<Integer, String>  hashTable = new HashTable<>(10);
        hashTable.put(1, "One");
        hashTable.put(2, "Two");

        Assert.assertEquals(hashTable.get(1), "One");
        hashTable.remove(1);
        Assert.assertNull(hashTable.get(1));

        Assert.assertEquals(hashTable.get(2), "Two");
        hashTable.remove(2);
        Assert.assertNull(hashTable.get(2));
    }
}
