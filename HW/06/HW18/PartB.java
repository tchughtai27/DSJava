/*
 * Talha Chughtai
 * 12/16/24
 * HW 18 
 */
import java.util.ArrayList;
import java.util.Scanner;

public class PartB {
    public static void main(String[] args) {
        ArrayList<Double> scores = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        double sum = 0;
        
        System.out.println("Enter test scores or 'q' to quit:");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) {
                break;
            }
            double score = Double.parseDouble(input);
            scores.add(score);
            sum += score;
        }
        
        System.out.println("\nTest Scores:");
        for (Double score : scores) {
            System.out.printf("%.2f\n", score);
        }
        
        if (!scores.isEmpty()) {
            double average = sum / scores.size();
            System.out.printf("\nAverage Score: %.2f\n", average);
        } else {
            System.out.println("No scores entered.");
        }
    }
}