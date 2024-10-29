/*
 * Talha Chughtai
 * ATCS
 * HW 09 Part A
 * 10/28
 */
import java.util.Scanner; 
public class PartA {
    public static void main(String[] args) {
        
        double total_score = 0;
        int score_count = 0;
        double score;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("Enter a positive test score or negative to quit: ");
            score = in.nextDouble();
            
            if (score >= 0) {
               total_score += score;
               score_count ++;
            }
        } 
        while (score >= 0);
        
        if (score_count > 0) {
            double average = total_score / score_count;
            System.out.println("Number of scores entered: " + score_count);
            System.out.printf("The average of the test scores is: %.2f%n", average);
        } else {
            System.out.println("No scores entered");
            
        }
    }
}