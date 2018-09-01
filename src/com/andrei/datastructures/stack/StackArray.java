package com.andrei.datastructures.stack;

import java.util.EmptyStackException;

/**
 * Stack implementation using fixed sized array
 *
 * @param <T>
 */
public class StackArray<T> {
    private static final int MAX_STACK_SIZE = 10;
    private Object[] elements;
    private int numOfElements;


    public StackArray() {
        elements = new Object[MAX_STACK_SIZE];
        numOfElements = 0;
    }

    /**
     * Add element to the top of the stack
     *
     * @param element element that should be added
     */
    public void push(T element) {
        if (numOfElements == MAX_STACK_SIZE) {
            throw new StackOverflowError();
        }

        elements[numOfElements] = element;
        numOfElements++;
    }

    /**
     * Get the top element and delete it from container
     *
     * @return the top element
     */
    @SuppressWarnings("unchecked")
    public T popElement() {
        if (numOfElements == 0) {
            throw new EmptyStackException();
        }

        T element = (T) elements[--numOfElements];
        elements[numOfElements] = null;

        return element;
    }

    /**
     * Get the top element without deleting it
     *
     * @return the top element
     */
    @SuppressWarnings("unchecked")
    public T top() {
        if (numOfElements == 0) {
            throw new EmptyStackException();
        }
        return (T) elements[numOfElements - 1];
    }

    /**
     * Check the Stack for empty
     *
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return numOfElements == 0;
    }

    /**
     * Get the number of elements in the stack
     *
     * @return number of elements
     */
    public int size() {
        return numOfElements;
    }
}
