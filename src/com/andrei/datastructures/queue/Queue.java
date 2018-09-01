package com.andrei.datastructures.queue;

public class Queue<T> {
    private static final int MAX_STACK_SIZE = 5;
    private Object[] elements;
    private int readIndex;
    private int writeIndex;


    public Queue() {
        this.elements = new Object[MAX_STACK_SIZE];
    }

    /**
     * Adds item at end of available storage
     *
     * @param value to be added
     */
    public void enqueue(T value) {
        if (full()) {
            throw new IllegalStateException();
        }

        elements[writeIndex] = value;
        if (writeIndex == elements.length - 1) {
            writeIndex = 0;
        } else {
            writeIndex++;
        }
    }

    /**
     * Returns value and removes least recently added element
     */
    @SuppressWarnings("unchecked")
    public T dequeue() {
        T value = (T) elements[readIndex];
        elements[readIndex] = null;
        if(readIndex == elements.length - 1) {
            readIndex = 0;
        } else {
            readIndex++;
        }
        return value;
    }

    public boolean empty() {
        return readIndex == writeIndex;
    }

    private boolean full() {
        if (readIndex < writeIndex) {
            return writeIndex - readIndex == elements.length - 2;
        } else {
            return writeIndex == readIndex - 1;
        }
    }
}
