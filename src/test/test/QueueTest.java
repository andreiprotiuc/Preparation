package test;

import com.andrei.datastructures.queue.Queue;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {

    @Test
    public void enqueue() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(new Integer(1), queue.dequeue());
        assertEquals(new Integer(2), queue.dequeue());
        assertTrue(queue.empty());
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        assertEquals(new Integer(3), queue.dequeue());
        assertEquals(new Integer(4), queue.dequeue());
        assertEquals(new Integer(5), queue.dequeue());
        assertEquals(new Integer(6), queue.dequeue());
        assertTrue(queue.empty());
    }

    @Test
    public void dequeue() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(new Integer(1), queue.dequeue());
        assertEquals(new Integer(2), queue.dequeue());
        assertTrue(queue.empty());
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        assertEquals(new Integer(3), queue.dequeue());
        assertEquals(new Integer(4), queue.dequeue());
        assertEquals(new Integer(5), queue.dequeue());
        assertEquals(new Integer(6), queue.dequeue());
        assertTrue(queue.empty());
    }

    @Test
    public void empty() {
        Queue<Integer> queue = new Queue<>();
        assertTrue(queue.empty());
    }
}