import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PartB {
    public static void main(String[] args) { // Starts similar to A
        Scanner userScanner = new Scanner(System.in);

        System.out.print("Please enter the filename: ");
        String filename = userScanner.nextLine();

        // Try to open
        try {
            // Open the file
            File file = new File(filename);
            Scanner fileScanner = new Scanner(file);

            // Process each line in the file
            while (fileScanner.hasNextLine()) {
                // Read the whole line
                String line = fileScanner.nextLine().trim(); // Read the full line

                // Split the line by comma to extract name and birth year
                String[] parts = line.split(","); // Split by the comma

                if (parts.length >= 2) {
                    // Read the name and birth year
                    String name = parts[0].trim(); // Trim any extra spaces from name, (this is correct?)
                    String birthYearStr = parts[1].trim(); // Trim extra spaces from birth year

                    // Try to parse the birth year and also handle exceptions
                    try {
                        // If the birth year is not "n/a", convert it to an integer
                        if (!birthYearStr.equals("n/a")) {
                            int birthYear = Integer.parseInt(birthYearStr);
                            System.out.println(name + " was born in " + birthYear + ".");
                        } else {
                            // If the birth year is "n/a", print this:
                            System.out.println("I do not know what year " + name + " was born.");
                        }
                    } catch (NumberFormatException e) {
                        // If there's an issue with parsing, it'll be handled here
                        System.out.println("I do not know what year " + name + " was born.");
                    }
                } else {
                    // If the line does not have the correct format, print an error
                    System.out.println("Invalid line format: " + line);
                }
            }

            // Close the file scanner
            fileScanner.close();

        } catch (FileNotFoundException e) {
            // If the file is not found, print an error message
            System.out.println("Error: File not found.");
        }

        // Close the user input scanner
        userScanner.close();
    }
}
