/*
 * Talha C
 * AT CS
 * HW15 Due: 12/10 
 */
import java.util.Arrays;
import java.util.Random;

public class PartC {
    public static void main(String[] args) {
        int size = 10000; // Change to larger number for larger arrays
        int[] values = new int[size];
        Random rand = new Random();

        // Fill the array with some random values
        for (int i = 0; i < values.length; i++) {
            values[i] = rand.nextInt(size) + 1;
        }

        // Generate random values to target and measure search times
        for (int i = 0; i < 10; i++) {
            int target = rand.nextInt(size) + 1;

            long startTime = System.currentTimeMillis();
            int linearResult = linearSearch(values, target);
            long linearTime = System.currentTimeMillis() - startTime;

            // Sort the array for binary search
            Arrays.sort(values);

            startTime = System.currentTimeMillis();
            int binaryResult = Arrays.binarySearch(values, target);
            long binaryTime = System.currentTimeMillis() - startTime;

            // Prints
            System.out.println("Target: " + target);
            System.out.println("Linear Search: " + (linearResult != -1 ? "Found" : "Not Found") + " in " + linearTime + "ms");
            System.out.println("Binary Search: " + (binaryResult >= 0 ? "Found" : "Not Found") + " in " + binaryTime + "ms");
            System.out.println();
        }
    }

    public static int linearSearch(int[] array, int tgtVal) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == tgtVal) {
                return i; // Return index if found
            }
        }
        return -1; // Not found
    }
}
