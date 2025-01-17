import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PartA {
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
            System.out.println("---------------------------------------------------------------");
            System.out.println("                   Top 5 Unemployment Rates");
            System.out.println("---------------------------------------------------------------");

            // Read the file and then you display the required data
            int rank = 1;
            while (fileScanner.hasNextLine() && rank <= 5) {
                // Read the next linw
                String line = fileScanner.nextLine();
                String[] data = line.split(","); // Split the line by commas

                if (data.length >= 4) {
                    String country = data[0].trim();
                    double unemploymentRate = Double.parseDouble(data[1].trim());
                    int ranking = Integer.parseInt(data[2].trim());
                    String region = data[3].trim(); // Trims the data

                    // Format and print the data for the top 5 countries
                    System.out.printf("Ranked # %-2d: %-15s | %-6.2f%% | %-20s%n", ranking, country, unemploymentRate,
                            region);
                    rank++;
                }
            }

            // Print the footer
            System.out.println("---------------------------------------------------------------");
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }

        // Close the user input scanner
        userScanner.close();
    }
}
