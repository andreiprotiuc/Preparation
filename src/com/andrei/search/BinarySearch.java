package com.andrei.search;

/**
 * Binary search implementation in iterative and recursive mode into sorted array
 */
public class BinarySearch {

    /**
     * Binary search into sorted array using recursive mode
     *
     * @param element that positions need to be find
     * @param array   where to search the element
     * @return position of the element in the array, -1 if not found
     */
    public int recursiveBinarySearch(int element, int[] array) {
        return recursiveBinarySearch(element, array, 0, array.length - 1);
    }

    private int recursiveBinarySearch(int element, int[] array, int min, int max) {
        if (min > max) {
            return -1;
        }

        int middle = min + (max - min) / 2;

        if (element == array[middle]) {
            return middle;
        } else {
            if (array[middle] > element) {
                return recursiveBinarySearch(element, array, min, middle - 1);
            } else {
                return recursiveBinarySearch(element, array, middle + 1, max);
            }
        }
    }

    /**
     * Binary search into sorted array using recursive mode
     *
     * @param element that positions need to be find
     * @param array   where to search the element
     * @return position of the element in the array, -1 if not found
     */
    public int iterativeBinarySearch(int element, int[] array) {
        int min = 0;
        int max = array.length - 1;
        int guess;

        while (min <= max) {
            guess = min + (max - min) / 2;
            if (array[guess] == element) {
                return guess;
            } else if (array[guess] > element) {
                max = guess - 1;
            } else if (array[guess] < element) {
                min = guess + 1;
            }
        }

        return -1;
    }
}
