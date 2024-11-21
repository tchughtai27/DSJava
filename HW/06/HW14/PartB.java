/*
 * Talha Chughtai 11/21/24
 * HW14 PartB
 */

public class PartB {
    public static void main(String[] args) {
        double[] numbers = { 2.2, 1.0, 3.7, 4.1, 88.0 };

        double sum = 0; // Var to store the sum of the elements

        // Enhanced for loop (idk if its actually called htis) to iterate the array
        for (double num : numbers) {
            System.out.println(num); // Print each element out
            sum += num; // Add the current element to the sum
        }

        double average = sum / numbers.length; // Calculate the average
        System.out.println("Avg = " + average); // Print the average
    }
}
