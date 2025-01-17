
/*
 * Talha C
 * ATCS
 * HW22
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PartA {
    public static void main(String[] args) {
        Scanner userScanner = new Scanner(System.in);

        while (true) {
            // Ask the user for a filename to enter or a # to quit
            System.out.print("Please enter a filename or '#' to quit: ");
            String filename = userScanner.nextLine();

            // If the user types "#", then we shall exit the loop
            if (filename.equals("#")) {
                System.out.println("Goodbye!");
                break;
            }

            // Try to open and read the file
            try {
                File file = new File(filename);
                Scanner fileScanner = new Scanner(file);

                // Read the file and print each word on a new line if can
                while (fileScanner.hasNext()) {
                    System.out.println(fileScanner.next());
                }

                fileScanner.close(); // Close the file when done
                // Catches FNF exception.
            } catch (FileNotFoundException e) {
                System.out.println("Error: File not found. Please try again.");
            }
        }

        userScanner.close();
    }
}
