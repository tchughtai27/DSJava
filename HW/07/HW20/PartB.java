
/*
 * Talha Chughtai
 * 1/9/2025
 * ATCS
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PartB {
    public static void main(String[] args) {
        int totalCharacters = 0;
        int totalLetters = 0;
        int totalDigits = 0;

        try (Scanner in = new Scanner(new File("characters.txt"))) {
            // Read the file character by character
            while (in.hasNextLine()) {
                String line = in.nextLine();
                for (char c : line.toCharArray()) {
                    totalCharacters++;
                    if (Character.isLetter(c)) {
                        totalLetters++;
                    } else if (Character.isDigit(c)) {
                        totalDigits++;
                    }
                }
            }

            // Print the file content
            System.out.println("Contents of the file:");
            try (Scanner in2 = new Scanner(new File("characters.txt"))) {
                while (in2.hasNextLine()) {
                    System.out.println(in2.nextLine());
                }
            }

            // Display counts
            System.out.println("\nStatistics:");
            System.out.println("Total characters scanned: " + totalCharacters);
            System.out.println("Total letters scanned: " + totalLetters);
            System.out.println("Total digits scanned: " + totalDigits);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: characters.txt");
        }
    }
}
