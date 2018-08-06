package test;

import com.andrei.datastructures.AutoResizeArray;


import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

public class ArrayTest {

    @Test
    public void testCapacity() throws NoSuchFieldException, IllegalAccessException {
        AutoResizeArray<Integer> array = new AutoResizeArray<>();
        Field field = AutoResizeArray.class.getDeclaredField("DEFAULT_CAPACITY");
        field.setAccessible(true);
        assertEquals(array.capacity(), field.getInt(array));

        for (int i = 0; i < 16; i++) {
            array.add(i);
        }
        assertEquals(array.capacity(), field.getInt(array));
        array.add(1);
        assertEquals(array.capacity(), field.getInt(array) * 2);
    }

    @Test
    public void testPop() {
        AutoResizeArray<Integer> array = new AutoResizeArray<>();
        array.add(2);
        array.add(3);
        assertEquals(2, array.size());

        assertEquals(3, (int) array.pop());
        assertEquals(2, (int) array.pop());

        assertEquals(0, array.size());
    }

    @Test(expected = IllegalStateException.class)
    public void testPopException() {
        AutoResizeArray<Integer> array = new AutoResizeArray<>();
        array.pop();
    }

    @Test
    public void testPrepend() {
        AutoResizeArray<Integer> array = new AutoResizeArray<>();
        array.add(2);
        array.add(3);
        array.prepend(1);
        assertEquals(3, array.size());
        assertEquals(1, (int) array.get(0));
    }


    @Test
    public void testAdd() {
        AutoResizeArray<Integer> array = new AutoResizeArray<>();
        assertEquals(0, array.size());
        array.add(2);
        assertEquals(1, array.size());
        assertEquals(2, (int) array.get(0));
        array.add(3);
        assertEquals(3, (int) array.get(1));
    }

    @Test
    public void testAddAtIndex() {
        AutoResizeArray<Integer> array = new AutoResizeArray<>();
        assertEquals(0, array.size());
        array.add(2, 0);
        assertEquals(1, array.size());
        assertEquals(2, (int) array.get(0));
        array.add(3);
        array.add(3, 2);
        assertEquals(3, (int) array.get(2));
    }

    @Test
    public void testDelete() {
        AutoResizeArray<Integer> array = new AutoResizeArray<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        assertEquals(5, array.size());

        array.delete(2);
        assertEquals(4, (int) array.get(2));
        assertEquals(4, array.size());

        array.delete(3);
        assertEquals(3, array.size());
        assertEquals(4, (int) array.get(2));

        array.delete(0);
        assertEquals(2, (int) array.get(0));

        array.delete(0);
        array.delete(0);
        assertEquals(0, array.size());
    }

    @Test
    public void testRemoveElement() {
        AutoResizeArray<Integer> array = new AutoResizeArray<>();
        array.add(3);
        array.add(2);
        array.add(3);
        array.add(2);
        array.add(5);

        array.remove(2);
        assertEquals(3, array.size());
        array.remove(3);
        assertEquals(1, array.size());
        array.remove(2);
        assertEquals(1, array.size());
        array.remove(5);
        assertEquals(0, array.size());
    }

    @Test
    public void findTest() {
        AutoResizeArray<Integer> array = new AutoResizeArray<>();
        assertEquals(-1, array.find(3));

        array.add(3);
        array.add(2);
        array.add(3);
        array.add(2);
        array.add(5);

        assertEquals(4, array.find(5));
        assertEquals(-1, array.find(8));
        assertEquals(1, array.find(2));
    }
}
