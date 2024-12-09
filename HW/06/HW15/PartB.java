/*
 * Talha C
 * AT CS
 * HW15 Due: 12/10 
 */
import java.util.Scanner;

public class PartB {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] values = new int[20];
        int currentSize = 0;

        System.out.println("Enter up to 20 integer values or 'q' to quit:");

        while (currentSize < values.length) {
            if (input.hasNextInt()) {
                values[currentSize] = input.nextInt();
                currentSize++;
            } else if (input.hasNext("q") || input.hasNext("Q")) {
                input.next(); // skip 'q'
                break;
            } else {
                System.out.println("Invalid input. Please enter an integer or 'q' to quit:");
                input.next(); // skip invalid input
            }
        }

        // Print the values
        for (int i = 0; i < currentSize; i++) {
            System.out.print(values[i]);
            if (i < currentSize - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();

        // Ask for integer
        System.out.print("Enter a integer value: ");
        int target = input.nextInt();
        int count = 0;

        // Count amount of times it occurs
        for (int i = 0; i < currentSize; i++) {
            if (values[i] == target) {
                count++;
            }
        }

        System.out.println("The value " + target + " occurs " + count + " times in your original data set.");
    }
}
