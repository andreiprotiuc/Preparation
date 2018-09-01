package com.andrei.datastructures.list;


import java.util.NoSuchElementException;

@SuppressWarnings("unused")
public class SingleLinkedList<T> {

    private NodeList<T> root;
    private int size;

    public SingleLinkedList() {
        this.root = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean empty() {
        return size == 0;
    }

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

    public void pushFront(T value) {
        NodeList<T> oldFirstNode = root;
        NodeList<T> node = new NodeList<>(value);
        node.setNext(oldFirstNode);
        root = node;
        size++;
    }

    public T popFront() {
        NodeList<T> f = root;
        if (f == null)
            throw new NoSuchElementException();
        root = root.getNext();
        size--;
        return f.getValue();
    }

    public void pushBack(T value) {
        if (root == null) {
            pushFront(value);
        } else {
            NodeList<T> lastNode = root;
            while (lastNode.getNext() != null) {
                lastNode = lastNode.getNext();
            }

            lastNode.setNext(new NodeList<>(value));
            size++;
        }
    }

    public T popBack() {
        if (empty()) {
            throw new NoSuchElementException();
        } else if (size == 1) {
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
            size--;

            return lastNode.getValue();
        }
    }

    public T front() {
        if (root == null) {
            throw new NoSuchElementException();
        }
        return root.getValue();
    }

    public T back() {
        if (root == null) {
            throw new NoSuchElementException();
        }
        NodeList<T> nodeList = root;
        while (nodeList.getNext() != null) {
            nodeList = nodeList.getNext();
        }

        return nodeList.getValue();
    }

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
            while (previousIndex < index -1) {
                previousIndex++;
                previousNode = previousNode.getNext();
            }

            NodeList<T> nodeToInsert = new NodeList<>(value);
            nodeToInsert.setNext(previousNode.getNext());
            previousNode.setNext(nodeToInsert);
            size++;
        }
    }

    public void erase(int index) {
        if (index >= size || root == null) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            root = root.getNext();
            size--;
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
        }
        size--;
    }

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

    public SingleLinkedList<T> reverse() {
        SingleLinkedList<T> reversedList = new SingleLinkedList<>();

        NodeList<T> previous = null;
        NodeList<T> current = root;
        NodeList<T> next;

        while (current != null) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }

        reversedList.root = previous;
        reversedList.size = size;
        return reversedList;
    }

    public void remove(Object value) {
        NodeList<T> currentNode = root;

        if (currentNode != null && currentNode.getValue().equals(value)) {
            erase(0);
            return;
        }

        while (currentNode != null) {
            if (currentNode.getNext() != null && currentNode.getNext().getValue().equals(value)) {
                currentNode.setNext(currentNode.getNext().getNext());
                size--;
                return;
            }

            currentNode = currentNode.getNext();
        }
    }
}
