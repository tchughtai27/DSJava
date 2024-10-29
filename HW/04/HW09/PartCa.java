/*
 * Talha Chughtai
 * ATCS
 * HW 09 Part Ca
 * 10/28
 */
import java.util.Random;

 class PartCa {
    public static void main(String[] args) {
        Random in = new Random();
        int sum = 0;
         for (int i = 0; i < 10; i++) {
            int random_num = in.nextInt(10) + 1;
            System.out.println(random_num + "");
            sum +=random_num;


         }
         
         
         double average = (double) sum / 10;
         System.out.printf("\nThe average of 10 numbers is: %.2f%n", average);
         
         // This average will vary because the sample size is smaller

    }  

}
