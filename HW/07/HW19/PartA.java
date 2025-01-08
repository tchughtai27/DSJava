/*Talha Chughtai
 * 1/7/2025
 * ATCS HW19
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PartA {
    public static void main(String[] args) {
        ArrayList<Integer> temperatures = new ArrayList<>();
        int lowestTemp = Integer.MAX_VALUE;

        try (Scanner scanner = new Scanner(new File("temps.txt"))) {
            // Read all values and find the lowest temperature
            while (scanner.hasNextInt()) {
                int temp = scanner.nextInt();
                temperatures.add(temp);
                if (temp < lowestTemp) {
                    lowestTemp = temp;
                }
            }

            // Print temperatures and mark the lowest
            for (int temp : temperatures) {
                System.out.print(temp);
                if (temp == lowestTemp) {
                    System.out.print(" <= lowest");
                }
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: temps.txt");
        }
    }
}
