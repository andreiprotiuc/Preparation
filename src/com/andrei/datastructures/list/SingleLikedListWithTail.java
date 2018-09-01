package com.andrei.datastructures.list;

import java.util.NoSuchElementException;

public class SingleLikedListWithTail<T> {

    private NodeList<T> root;
    private NodeList<T> tail;
    private int size;

    public SingleLikedListWithTail() {
        this.root = null;
        this.size = 0;
    }

    /**
     * Get the size of the {@link SingleLikedListWithTail}
     *
     * @return the size of {@link SingleLikedListWithTail}
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the {@link SingleLikedListWithTail} is empty
     *
     * @return true if {@link SingleLikedListWithTail} is empty, false otherwise
     */
    public boolean empty() {
        return size == 0;
    }

    /**
     * Get the element from list by index. The method can throw {@link IndexOutOfBoundsException} if the index is not in the ranges
     *
     * @param index index of the element
     * @return T element
     */
    public T get(int index) {
        if (size <= 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        int currentIndex = 0;
        NodeList<T> currentItem = root;
        if (index == 0) {
            return currentItem.getValue();
        }

        while (currentIndex < index) {
            currentItem = currentItem.getNext();
            currentIndex++;
        }

        return currentItem.getValue();
    }

    /**
     * Add element at the start of {@link SingleLikedListWithTail}
     *
     * @param value to be added
     */
    public void pushFront(T value) {
        NodeList<T> node = new NodeList<>(value);
        node.setNext(root);
        root = node;
        if (tail == null) {
            tail = root;
        }
        size++;
    }

    /**
     * Return the first element of the {@link SingleLikedListWithTail}, and delete it from list
     *
     * @return the first element
     */
    public T popFront() {
        NodeList<T> f = root;
        if (f == null)
            throw new NoSuchElementException("Empty list");
        root = root.getNext();
        if (root == null) {
            tail = null;
        }

        size--;
        return f.getValue();
    }

    /**
     * Add element at the end of {@link SingleLikedListWithTail}
     *
     * @param value value to be added
     */
    public void pushBack(T value) {
        NodeList<T> nodeToPush = new NodeList<>(value);
        if (tail == null) {
            root = tail = nodeToPush;
        } else {
            tail.setNext(nodeToPush);
            tail = nodeToPush;
        }
        size++;
    }

    /**
     * Get the last element and delete it from list
     *
     * @return the last element
     */
    public T popBack() {
        if (empty()) {
            throw new NoSuchElementException();
        } else if (root == tail) {
            return popFront();
        } else {
            int index = 0;
            NodeList<T> lastButOneNode = root;
            while (index < size - 2) {
                lastButOneNode = lastButOneNode.getNext();
                index++;
            }

            NodeList<T> lastNode = lastButOneNode.getNext();
            lastButOneNode.setNext(null);
            tail = lastButOneNode;
            size--;

            return lastNode.getValue();
        }
    }

    /**
     * Get first element from the list without deleting it
     *
     * @return value of the first element
     */
    public T front() {
        if (root == null) {
            throw new NoSuchElementException();
        }
        return root.getValue();
    }

    /**
     * Get last element from the list without deleting it
     *
     * @return value of the last element
     */
    public T back() {
        if (tail == null) {
            throw new NoSuchElementException();
        }
        return tail.getValue();
    }

    /**
     * Insert value at giving index
     *
     * @param index where to add the value
     * @param value to be added
     */
    public void insert(int index, T value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (index == 0) {
            pushFront(value);
        } else if (index == size) {
            pushBack(value);
        } else {
            NodeList<T> previousNode = root;
            int previousIndex = 0;
            while (previousIndex < index - 1) {
                previousIndex++;
                previousNode = previousNode.getNext();
            }

            NodeList<T> nodeToInsert = new NodeList<>(value);
            nodeToInsert.setNext(previousNode.getNext());
            previousNode.setNext(nodeToInsert);
            size++;
        }
    }

    /**
     * Remove element at giving index
     *
     * @param index of the element that should be removed
     */
    public void erase(int index) {
        if (index >= size || root == null) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            root = root.getNext();
            size--;
            if (root == null) {
                tail = null;
            }
            return;
        }

        int currentIndex = 0;
        NodeList<T> previousNode = root;

        while (currentIndex < index - 1) {
            previousNode = previousNode.getNext();
            currentIndex++;
        }

        if (previousNode.getNext() != null && previousNode.getNext().getNext() != null) {
            previousNode.setNext(previousNode.getNext().getNext());
        } else {
            previousNode.setNext(null);
            tail = previousNode;
        }
        size--;
    }

    /**
     * Get the n'th element from the end of the list
     *
     * @param n the n'th element
     * @return element
     */
    public T valueFromEnd(int n) {
        if (n >= size || n < 0 || root == null) {
            throw new IndexOutOfBoundsException();
        }
        int neededElementPosition = size - n;
        int currentIndex = 0;
        NodeList<T> neededNode = root;
        while (currentIndex < neededElementPosition) {
            neededNode = neededNode.getNext();
            currentIndex++;
        }

        return neededNode.getValue();
    }

    /**
     * Reverse the list elements
     *
     * @return new list that has elements in the reverse order
     */
    public SingleLikedListWithTail<T> reverse() {
        SingleLikedListWithTail<T> reversedList = new SingleLikedListWithTail<>();

        NodeList<T> previous = null;
        NodeList<T> current = root;
        NodeList<T> next;

        while (current != null) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }

        reversedList.tail = root;
        reversedList.root = previous;
        reversedList.size = size;
        return reversedList;
    }

    /**
     * Remove first matching value from the list if found.
     *
     * @param value that should be removed
     */
    public void remove(Object value) {
        NodeList<T> currentNode = root;

        if (currentNode != null && currentNode.getValue().equals(value)) {
            erase(0);
            return;
        }

        while (currentNode != null) {
            if (currentNode.getNext() != null && currentNode.getNext().getValue().equals(value)) {
                NodeList<T> lastPartOfListNode = currentNode.getNext().getNext();
                currentNode.setNext(lastPartOfListNode);
                if (lastPartOfListNode == null) {
                    tail = currentNode;
                }
                size--;
                return;
            }

            currentNode = currentNode.getNext();
        }
    }
}
