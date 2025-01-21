import java.util.ArrayList;
import java.util.Scanner;

public class PRACTICAL_0506_B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Double> quizScores = new ArrayList<>();

        System.out.println("Enter quiz scores as doubles (or 'q' to quit):");

        while (true) {
            System.out.print("Score: ");
            String input = in.nextLine();

            if (input.equalsIgnoreCase("q")) {
                break;
            }

            try {

                double score = Double.parseDouble(input);
                quizScores.add(score);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number or 'q' to quit.");
            }
        }

        System.out.println("--------------");
        System.out.println("Quiz Scores:");
        System.out.println("--------------");
        for (double score : quizScores) {
            System.out.printf("%10.2f%n", score);
        }

        if (!quizScores.isEmpty()) {
            double sum = 0;
            for (double score : quizScores) {
                sum += score;
            }
            double average = sum / quizScores.size();
            System.out.printf("%nAverage Score: %.2f%n", average);
        } else {
            System.out.println("\nNo scores were entered.");
        }

        in.close();
    }
}
