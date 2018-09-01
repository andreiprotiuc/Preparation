package test;

import com.andrei.datastructures.list.SingleLikedListWithTail;
import org.junit.Test;

import static org.junit.Assert.*;

public class SingleLikedListWithTailTest {

    @Test
    public void testSize() {
        SingleLikedListWithTail<Integer> list = new SingleLikedListWithTail<>();
        assertEquals(0, list.size());

        list.pushFront(2);
        assertEquals(1, list.size());
        list.popFront();
        assertEquals(0, list.size());
        list.insert(0, 1);
        assertEquals(1, list.size());
        list.erase(0);
        assertEquals(0, list.size());
        list.pushBack(1);
        assertEquals(1, list.size());
        list.popBack();
        assertEquals(0, list.size());
        list.pushFront(1);
        list.remove(1);
        assertEquals(0, list.size());
    }

    @Test
    public void testEmpty() {
        SingleLikedListWithTail<Integer> list = new SingleLikedListWithTail<>();
        assertTrue(list.empty());
        list.pushFront(1);
        list.popFront();
        assertTrue(list.empty());
    }

    @Test
    public void testGet() {
        SingleLikedListWithTail<Integer> list = new SingleLikedListWithTail<>();
        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(3);
        list.pushBack(4);
        list.pushBack(5);
        list.pushBack(6);
        list.pushBack(7);
        assertEquals(7, list.size());
        assertEquals(new Integer(1), list.get(0));
        assertEquals(new Integer(2), list.get(1));
        assertEquals(new Integer(3), list.get(2));
        assertEquals(new Integer(4), list.get(3));
        assertEquals(new Integer(5), list.get(4));
        assertEquals(new Integer(6), list.get(5));
        assertEquals(new Integer(7), list.get(6));
    }

    @Test
    public void testPushFront() {
        SingleLikedListWithTail<Integer> list = new SingleLikedListWithTail<>();
        list.pushFront(1);
        assertEquals(new Integer(1), list.get(0));
        list.pushFront(2);
        assertEquals(new Integer(2), list.get(0));
        list.pushFront(3);
        assertEquals(new Integer(3), list.get(0));
        assertEquals(3, list.size());
    }

    @Test
    public void testPopFront() {
        SingleLikedListWithTail<Integer> list = new SingleLikedListWithTail<>();
        list.pushFront(1);
        list.pushFront(2);
        list.pushFront(3);

        assertEquals(3, list.size());
        assertEquals(new Integer(3), list.popFront());
        assertEquals(new Integer(2), list.popFront());
        assertEquals(new Integer(1), list.popFront());
    }

    @Test
    public void testPushBack() {
        SingleLikedListWithTail<Integer> list = new SingleLikedListWithTail<>();
        list.pushBack(1);
        assertEquals(new Integer(1), list.get(0));
        list.pushBack(2);
        assertEquals(new Integer(2), list.get(1));
        list.pushBack(3);
        assertEquals(new Integer(3), list.get(2));
        assertEquals(3, list.size());
    }

    @Test
    public void testPopBack() {
        SingleLikedListWithTail<Integer> list = new SingleLikedListWithTail<>();
        list.pushFront(1);
        list.pushFront(2);
        list.pushFront(3);

        assertEquals(3, list.size());
        assertEquals(new Integer(1), list.popBack());
        assertEquals(new Integer(2), list.popBack());
        assertEquals(new Integer(3), list.popBack());
    }

    @Test
    public void testFront() {
        SingleLikedListWithTail<Integer> list = new SingleLikedListWithTail<>();
        list.pushFront(1);
        list.pushFront(2);
        list.pushFront(3);

        assertEquals(3, list.size());
        assertEquals(new Integer(3), list.front());
        assertEquals(3, list.size());
    }

    @Test
    public void testBack() {
        SingleLikedListWithTail<Integer> list = new SingleLikedListWithTail<>();
        list.pushFront(1);
        list.pushFront(2);
        list.pushFront(3);

        assertEquals(3, list.size());
        assertEquals(new Integer(1), list.back());
        assertEquals(3, list.size());
    }

    @Test
    public void testInsert() {
        SingleLikedListWithTail<Integer> list = new SingleLikedListWithTail<>();
        list.insert(0, 1);
        list.insert(1, 2);
        list.insert(1, 3);
        assertEquals(new Integer(1), list.get(0));
        assertEquals(new Integer(2), list.get(2));
        assertEquals(new Integer(3), list.get(1));
    }

    @Test
    public void testErase() {
        SingleLikedListWithTail<Integer> list = new SingleLikedListWithTail<>();
        list.insert(0, 1);
        list.insert(1, 2);
        list.insert(1, 3);

        list.erase(2);
        assertEquals(2, list.size());
        assertEquals(new Integer(3), list.get(1));
        assertEquals(new Integer(1), list.get(0));
        list.erase(0);
        assertEquals(1, list.size());
        assertEquals(new Integer(3), list.get(0));
    }

    @Test
    public void valueFromEnd() {
        SingleLikedListWithTail<Integer> list = new SingleLikedListWithTail<>();
        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(3);
        list.pushBack(4);
        list.pushBack(5);
        list.pushBack(6);
        list.pushBack(7);

        assertEquals(new Integer(4), list.valueFromEnd(4));
    }

    @Test
    public void testReverse() {
        SingleLikedListWithTail<Integer> list = new SingleLikedListWithTail<>();
        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(3);
        list.pushBack(4);
        list.pushBack(5);
        list.pushBack(6);
        list.pushBack(7);
        list = list.reverse();

        assertEquals(new Integer(1), list.get(6));
        assertEquals(new Integer(2), list.get(5));
        assertEquals(new Integer(3), list.get(4));
        assertEquals(new Integer(4), list.get(3));
        assertEquals(new Integer(5), list.get(2));
        assertEquals(new Integer(6), list.get(1));
        assertEquals(new Integer(7), list.get(0));

    }

    @Test
    public void testRemove() {
        SingleLikedListWithTail<Integer> list = new SingleLikedListWithTail<>();
        list.pushBack(1);
        list.pushBack(2);
        list.remove(4);
        assertEquals(2, list.size());
        list.remove(1);
        assertEquals(new Integer(2), list.get(0));
        assertEquals(1, list.size());
        list.remove(2);
        assertTrue(list.empty());
    }
}