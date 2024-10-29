/*
 * Talha Chughtai
 * ATCS
 * HW 09 Part Cb
 * 10/28
 */
import java.util.Random;

public class PartCb {
    public static void main(String[] args) {
        Random in = new Random();
        
        int sum_1000 = 0;
         for (int i = 0; i < 1000; i++) {
            int randomNum = in.nextInt(1000) + 1;
            System.out.println(randomNum + "");
            sum_1000 +=randomNum;


         }
         double average_1000 = (double) sum_1000 / 1000;
         System.out.printf("\nThe average of 1000 numbers is: %.2f%n", average_1000);
    }
}
// The average of this should be closer to the middle because it is a larger sample size. 
