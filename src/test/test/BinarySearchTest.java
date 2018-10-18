package test;

import com.andrei.search.BinarySearch;
import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest {

    @Test
    public void recursiveBinarySearch() {
        BinarySearch binarySearch = new BinarySearch();
        int[] arrayOfInts = new int[]{1, 2, 5, 6, 9, 10, 20, 158, 243};
        Assert.assertEquals(2, binarySearch.recursiveBinarySearch(5, arrayOfInts));
        Assert.assertEquals(8, binarySearch.recursiveBinarySearch(243, arrayOfInts));
        Assert.assertEquals(-1, binarySearch.recursiveBinarySearch(21, arrayOfInts));
        Assert.assertEquals(6, binarySearch.recursiveBinarySearch(20, arrayOfInts));
        Assert.assertEquals(0, binarySearch.recursiveBinarySearch(1, arrayOfInts));
    }

    @Test
    public void iterativeBinarySearch() {
        BinarySearch binarySearch = new BinarySearch();
        int[] arrayOfInts = new int[]{1, 2, 5, 6, 9, 10, 20, 158, 243};
        Assert.assertEquals(2, binarySearch.iterativeBinarySearch(5, arrayOfInts));
        Assert.assertEquals(8, binarySearch.iterativeBinarySearch(243, arrayOfInts));
        Assert.assertEquals(-1, binarySearch.iterativeBinarySearch(21, arrayOfInts));
        Assert.assertEquals(6, binarySearch.iterativeBinarySearch(20, arrayOfInts));
        Assert.assertEquals(0, binarySearch.iterativeBinarySearch(1, arrayOfInts));
    }

}
