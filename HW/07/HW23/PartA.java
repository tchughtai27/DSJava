import java.util.Scanner;

public class PartA {

    // Method to get quiz score
    public static int getQuizScore(Scanner in) {
        System.out.print("Enter a quiz score (0 to 100): ");
        int score = in.nextInt();
        if (score < 0 || score > 100) {
            throw new ArithmeticException("Invalid quiz score. Must be between 0 and 100.");
        }
        return score;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            int score = getQuizScore(in);
            System.out.println("You entered a valid quiz score: " + score);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            in.close();
        }
    }
}
