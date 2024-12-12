import java.util.Scanner;

public class PartA {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] scores = new double[100]; // Can adjust this size as needed
        int count = 0;

        // Scan quiz scores from user
        System.out.println("Enter quiz scores (q to quit):");
        while (true) {
            String scoreStr = input.next();
            if (scoreStr.equalsIgnoreCase("q")) {
                break;
            }
            double score = Double.parseDouble(scoreStr);
            scores[count++] = score;
        }

        // Print the quiz scores out
        System.out.println("Your quiz scores:");
        for (int i = 0; i < count; i++) {
            System.out.printf("%.2f ", scores[i]);
        }
        System.out.println();

        // Ask if the user wants to drop the lowest score
        System.out.print("Do you want to drop the lowest score? (y/n): ");
        String choice = input.next();
        if (choice.equalsIgnoreCase("y")) {
            dropLowestScore(scores, count);

            // Reprint the scores after dropping the lowest one
            System.out.println("Your quiz scores after dropping the lowest:");
            for (int i = 0; i < count - 1; i++) {
                System.out.printf("%.2f ", scores[i]);
            }
            System.out.println();
        }
    }

    public static void dropLowestScore(double[] scores, int count) {
        double lowest = scores[0];
        int lowestIndex = 0;

        // Find the index of the first of the lowest score
        for (int i = 1; i < count; i++) {
            if (scores[i] < lowest) {
                lowest = scores[i];
                lowestIndex = i;
            }
        }

        // Shift elements to the left to remove the lowest score
        for (int i = lowestIndex; i < count - 1; i++) {
            scores[i] = scores[i + 1];
        }
    }
}