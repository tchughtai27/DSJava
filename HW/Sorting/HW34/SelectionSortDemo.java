import java.util.Arrays;
import util.*;

/**
 * This program demonstrates the selection sort algorithm by
 * sorting an array that is filled with random numbers.
 */
public class SelectionSortDemo {
    public static void main(String[] args) {
        int[] a = ArrayUtil.randomIntArray(20, 100);
        System.out.println("orig:   " + Arrays.toString(a));

        SelectionSorter.sort(a);

        System.out.println("sorted: " + Arrays.toString(a));
    }
}