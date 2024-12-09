/*
 * Talha C
 * AT CS
 * HW15 Due: 12/10 
 */
import java.util.Arrays;
import java.util.Scanner;

public class PartA {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] values = new int[10];
        int currentSize = 0;

        System.out.println("Enter up to 10 integer values or 'q' to quit:");

        while (currentSize < values.length) {
            if (input.hasNextInt()) {
                values[currentSize] = input.nextInt();
                currentSize++;
            } else if (input.hasNext("q") || input.hasNext("Q")) {
                input.next(); // skip q
                break;
            } else {
                System.out.println("Invalid input. Please enter an integer or 'q' to quit:");
                input.next(); // skip invalid input
            }
        }

        // Prints unsorted values
        System.out.print("*");
        for (int i = 0; i < currentSize; i++) {
            System.out.print(values[i] + "*");
        }
        System.out.println();

        // Sorts the valid parts of array
        Arrays.sort(values, 0, currentSize);

        // Print values in reversed order
        for (int i = currentSize - 1; i >= 0; i--) {
            System.out.print(values[i]);
            if (i > 0) {
                System.out.print(",");
            }
        }
        System.out.println();
    }
}
