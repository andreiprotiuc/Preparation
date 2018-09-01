package com.andrei.datastructures.array;

/**
 * Resizable ArrayList data structure
 *
 * @param <T>
 */
public class AutoResizeArray<T> {

    private static final int DEFAULT_CAPACITY = 16;
    private int capacity;
    private int size;
    private Object[] container;

    public AutoResizeArray() {
        this.container = new Object[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
    }

    /**
     * Get the number of element stored in array
     *
     * @return count of elements
     */
    public int size() {
        return this.size;
    }

    /**
     * Get the number of items that array can hold until resizing
     *
     * @return the number of items that array can hold
     */
    public int capacity() {
        return this.capacity;
    }

    /**
     * Check if the array is empty
     *
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Get element at index. Can throw {@link IndexOutOfBoundsException} if the index is < 0 or index >= {@link AutoResizeArray#size()}
     * <p>
     *
     * @param index index of the element to be returned
     * @return element that is stored at index
     */
    @SuppressWarnings("unchecked")
    public T get(int index) {
        rangeCheck(index);
        return (T) container[index];
    }

    /**
     * Add element at the end of the array
     *
     * @param element element to be added
     */
    public void add(T element) {
        if (size == capacity) {
            capacity *= 2;
            resize(capacity);
        }

        container[size] = element;
        size++;
    }

    /**
     * Add element at the specific index, all the data will be shifted to the right
     *
     * @param element element to be stored
     * @param index   position where to store the element
     */
    public void add(T element, int index) {
        rangeCheckAdd(index);
        if (size == capacity) {
            resize(capacity * 2);
        }
        // Shift elements to the right
        for (int i = size; i > index; i--) {
            container[i] = container[i - 1];
        }

        //Now the element of index is empty, than we can add it
        container[index] = element;
        size++;
    }

    /**
     * Insert element at the beginning of array
     *
     * @param element - element that should be inserted
     */
    public void prepend(T element) {
        add(element, 0);
    }


    @SuppressWarnings("unchecked")
    public T pop() {
        if (size == 0) {
            throw new IllegalStateException("Array is empty, cannot pop from the empty array");
        }

        T element = (T) container[size - 1];
        this.size--;
        container[size] = null;
        return element;
    }

    /**
     * Delete item at index
     *
     * @param index of item to be deleted
     */
    public void delete(int index) {
        rangeCheck(index);

        if (size <= capacity / 4) {
            resize(capacity / 2);
        }

        for (int i = index; i < size - 1; i++) {
            container[i] = container[i + 1];
        }
        size--;
        container[size] = null;
    }

    /**
     * Looks for value and removes index holding it (even if in multiple places)
     */
    public void remove(T element) {
        int i = 0;
        while (i < size) {
            if (container[i].equals(element)) {
                delete(i);
            } else {
                i++;
            }
        }
    }

    /**
     * Get index of the given element or -1 if not exists
     *
     * @param element element to be found
     * @return index of the element or -1 if not exists
     */
    public int find(T element) {
        for (int index = 0; index < size; index++) {
            if (container[index].equals(element)) {
                return index;
            }
        }
        return -1;
    }

    private void resize(int newCapacity) {
        if (newCapacity <= DEFAULT_CAPACITY) {
            return;
        }
        // We don't have space anymore then allocate new array with double size
        Object[] newArray = new Object[newCapacity];
        for (int index = 0; index < container.length; index++) {
            newArray[index] = container[index];
        }
        container = newArray;
        capacity = newCapacity;
    }

    /**
     * A version of rangeCheck used by add and addAll.
     */
    private void rangeCheckAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    /**
     * Checks if the given index is in range.  If not, throws an appropriate
     * runtime exception.
     */
    private void rangeCheck(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }
}
