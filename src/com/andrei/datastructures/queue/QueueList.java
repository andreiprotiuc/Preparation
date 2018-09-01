package com.andrei.datastructures.queue;

import com.andrei.datastructures.list.SingleLikedListWithTail;

public class QueueList<T> {
    private SingleLikedListWithTail<T> elements;

    public QueueList() {
        this.elements = new SingleLikedListWithTail<>();
    }

    /**
     * Adds item at end of available storage
     *
     * @param value to be added
     */
    public void enqueue(T value) {
        elements.pushBack(value);
    }

    /**
     * Returns value and removes least recently added element
     */
    public T dequeue() {
        return elements.popFront();
    }

    public boolean empty() {
        return elements.empty();
    }
}
