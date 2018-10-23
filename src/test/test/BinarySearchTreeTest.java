package test;

import com.andrei.datastructures.trees.BinarySearchTree;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    BinarySearchTree<Integer> binarySearchTree;

    @Before
    public void init() {
        binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.insert(7);
        binarySearchTree.insert(5);
        binarySearchTree.insert(2);
        binarySearchTree.insert(9);
        binarySearchTree.insert(8);
        binarySearchTree.insert(12);
        binarySearchTree.insert(3);
        binarySearchTree.insert(1);
    }

    @Test
    public void testInsert() {
        assertEquals(8, binarySearchTree.count());
        assertFalse(binarySearchTree.contains(20));
        binarySearchTree.insert(20);
        assertTrue(binarySearchTree.contains(20));
    }

    @Test
    public void testDelete() {
        assertTrue(binarySearchTree.count() > 0);
        binarySearchTree.delete();
        assertEquals(0, binarySearchTree.count());
    }

    @Test
    public void testContains() {
        assertTrue(binarySearchTree.contains(7));
        assertTrue(binarySearchTree.contains(5));
        assertTrue(binarySearchTree.contains(2));
        assertTrue(binarySearchTree.contains(9));
        assertTrue(binarySearchTree.contains(8));
        assertTrue(binarySearchTree.contains(12));
        assertTrue(binarySearchTree.contains(3));
        assertTrue(binarySearchTree.contains(1));

        assertFalse(binarySearchTree.contains(20));
        binarySearchTree.delete();
        assertFalse(binarySearchTree.contains(7));
    }

    @Test
    public void testCount() {
        assertEquals(8, binarySearchTree.count());
        binarySearchTree.insert(20);
        assertEquals(9, binarySearchTree.count());
        binarySearchTree.deleteValue(20);
        assertEquals(8, binarySearchTree.count());
        binarySearchTree.delete();
        assertEquals(0, binarySearchTree.count());
    }

    @Test
    public void testHeight() {

    }

    @Test
    public void testMin() {
        assertEquals(1, (int) binarySearchTree.min());
        binarySearchTree.insert(0);
        assertEquals(0, (int) binarySearchTree.min());
        binarySearchTree.delete();
        assertNull(binarySearchTree.min());
    }

    @Test
    public void testMax() {
        assertEquals(12, (int) binarySearchTree.max());
        binarySearchTree.insert(50);
        assertEquals(50, (int) binarySearchTree.max());
        binarySearchTree.delete();
        assertNull(binarySearchTree.max());
    }

    @Test
    public void testIsBinarySearchTree() {
        assertTrue(binarySearchTree.isBinarySearchTree());
        binarySearchTree.deleteValue(7);
        assertTrue(binarySearchTree.isBinarySearchTree());
        binarySearchTree.delete();
        assertTrue(binarySearchTree.isBinarySearchTree());
    }

    @Test
    public void testRemove() {
        assertTrue(binarySearchTree.contains(7));
        binarySearchTree.deleteValue(7);
        assertTrue(binarySearchTree.isBinarySearchTree());
        assertFalse(binarySearchTree.contains(7));

        assertTrue(binarySearchTree.contains(1));
        binarySearchTree.deleteValue(1);
        assertTrue(binarySearchTree.isBinarySearchTree());
        assertFalse(binarySearchTree.contains(1));

        assertTrue(binarySearchTree.contains(9));
        binarySearchTree.deleteValue(9);
        assertTrue(binarySearchTree.isBinarySearchTree());
        assertFalse(binarySearchTree.contains(9));

        assertTrue(binarySearchTree.contains(2));
        binarySearchTree.deleteValue(2);
        assertTrue(binarySearchTree.isBinarySearchTree());
        assertFalse(binarySearchTree.contains(2));

        assertTrue(binarySearchTree.contains(8));
        binarySearchTree.deleteValue(8);
        assertTrue(binarySearchTree.isBinarySearchTree());
        assertFalse(binarySearchTree.contains(8));

        assertTrue(binarySearchTree.contains(3));
        binarySearchTree.deleteValue(3);
        assertTrue(binarySearchTree.isBinarySearchTree());
        assertFalse(binarySearchTree.contains(3));

        assertTrue(binarySearchTree.contains(5));
        binarySearchTree.deleteValue(5);
        assertTrue(binarySearchTree.isBinarySearchTree());
        assertFalse(binarySearchTree.contains(5));

        assertTrue(binarySearchTree.contains(12));
        binarySearchTree.deleteValue(12);
        assertTrue(binarySearchTree.isBinarySearchTree());
        assertFalse(binarySearchTree.contains(12));

        assertEquals(0, binarySearchTree.count());
    }

    @Test
    public void testSuccessor() {
        assertEquals(8, (int)binarySearchTree.getSuccessor(7));
        assertEquals(7, (int)binarySearchTree.getSuccessor(5));
        assertEquals(3, (int)binarySearchTree.getSuccessor(2));
        assertEquals(12, (int)binarySearchTree.getSuccessor(9));
        assertEquals(9, (int)binarySearchTree.getSuccessor(8));
        assertNull(binarySearchTree.getSuccessor(12));
        assertEquals(5, (int)binarySearchTree.getSuccessor(3));
        assertEquals(2, (int)binarySearchTree.getSuccessor(1));
    }
}
