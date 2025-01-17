import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PartB {
    public static void main(String[] args) {
        // Open a scanner to read input
        Scanner userScanner = new Scanner(System.in);

        System.out.print("Please enter the filename: ");
        String filename = userScanner.nextLine();

        // Try to open the file
        try {
            File file = new File(filename);
            Scanner fileScanner = new Scanner(file);

            // Print the header
            System.out.println("Department Name    | Manager    | Sales Revenue");

            // Read the file and display the required data
            while (fileScanner.hasNextLine()) {
                // Read the next line
                String line = fileScanner.nextLine();
                String[] data = line.split(","); // Split the line by commas

                if (data.length == 3) {
                    String departmentName = data[0].trim(); // Trim the data
                    String managerName = data[1].trim();
                    String salesData = data[2].trim();

                    double salesRevenue = 0.0;

                    // Check if sales data is valid
                    if (!salesData.equals("n/a")) {
                        try {
                            salesRevenue = Double.parseDouble(salesData);
                        } catch (NumberFormatException e) {
                            salesRevenue = 0.0;
                        }
                    }

                    // Format and print the data
                    System.out.printf("%-18s | %-10s | $%-10.2f%n", departmentName, managerName, salesRevenue);
                }
            }
        } catch (FileNotFoundException e) { // FNF error
            System.out.println("Error: File not found.");
        }

        // Close the user input scanner
        userScanner.close();
    }
}
