
/*
 * Talha Chughtai
 * 1/9/2025
 * ATCS
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class PartA {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("customerdata.txt"))) {
            // Configure teh scanner to use commas, spaces, and newlines as the delimiters
            scanner.useDelimiter("[,\\s\\n]+");

            // Print table
            System.out.println("---------------------------------------");
            System.out.println("   ID  |    Name     |     Balance ");
            System.out.println("---------------------------------------");

            // Process format each line of input
            DecimalFormat currencyFormat = new DecimalFormat("$#,##0.00");
            while (scanner.hasNext()) {
                // Read data
                int id = scanner.nextInt();
                String name = scanner.next();
                double balance = scanner.nextDouble();

                // Format and print the data
                System.out.printf("%06d | %10s | %13s%n", id, name, currencyFormat.format(balance));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: customerdata.txt");
        }
    }
}
