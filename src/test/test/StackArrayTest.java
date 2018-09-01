package test;

import com.andrei.datastructures.stack.StackArray;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackArrayTest {

    @Test
    public void push() {
        StackArray<Integer> stack = new StackArray<>();

        stack.push(1);
        assertEquals(1, stack.size());
        assertEquals(new Integer(1), stack.top());

        stack.push(2);
        assertEquals(2, stack.size());
        assertEquals(new Integer(2), stack.top());
    }

    @Test
    public void popElement() {
        StackArray<Integer> stack = new StackArray<>();

        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.size());

        assertEquals(new Integer(2), stack.popElement());
        assertEquals(1, stack.size());
        assertEquals(new Integer(1), stack.popElement());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void top() {
        StackArray<Integer> stack = new StackArray<>();

        stack.push(1);
        assertEquals(new Integer(1), stack.top());
        assertEquals(1, stack.size());

        stack.push(2);
        assertEquals(new Integer(2), stack.top());
        assertEquals(2, stack.size());
    }

    @Test
    public void emptyCheck() {
        StackArray<Integer> stack = new StackArray<>();
        assertTrue(stack.isEmpty());
        stack.push(1);
        stack.popElement();
        assertTrue(stack.isEmpty());
    }

}