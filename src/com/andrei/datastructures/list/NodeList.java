package com.andrei.datastructures.list;

@SuppressWarnings("unused")
class NodeList<T> {
    private T value;
    private NodeList<T> next;

    NodeList(T value) {
        this.value = value;
        this.next = null;
    }

    T getValue() {
        return value;
    }

    void setValue(T value) {
        this.value = value;
    }

    NodeList<T> getNext() {
        return next;
    }

    void setNext(NodeList<T> next) {
        this.next = next;
    }
}
