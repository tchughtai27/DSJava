import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PartB {
    public static void main(String[] args) {
        ArrayList<Double> quizScores = new ArrayList<>();
        double total = 0;

        try (Scanner scanner = new Scanner(new File("quizzes.txt"))) {
            // Read scores and calculate the total
            while (scanner.hasNextDouble()) {
                double score = scanner.nextDouble();
                quizScores.add(score);
                total += score;
            }

            //  calculate average
            double average = total / quizScores.size();

            // Print formatted quiz scores
            for (int i = 0; i < quizScores.size(); i++) {
                System.out.printf("Quiz %03d: %6.2f%n", i, quizScores.get(i));
            }

            // Print separator and average to the console
            System.out.println("----------------");
            System.out.printf("Average:   %6.2f%n", average);

        } catch (FileNotFoundException e) {
            System.out.println("File not found: quizzes.txt");
        }
    }
}
