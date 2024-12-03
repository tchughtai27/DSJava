/*
 * Talha Chughtai 11/21/24
 * HW14 PartB
 */

import java.util.Scanner;

public class InClass {
    public static void main(String[] args) {
        final int LENGTH = 100;
        double[] scores = new double[LENGTH];
        int currentSize = 0;
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Enter score or q to quit: ");
            if (in.hasNext("q") || in.hasNext("Q")) {
                in.next();

                System.out.println("Done");
                break;
            }
            if (currentSize < scores.length){
                double value = in.nextDouble();
                scores[currentSize] = in.nextDouble();
        currentSize++;
        }   else {
            System.out.println("Array has reached amxed capacity");
            System.out.println("Done");
            break;
        }  
        System.out.println("---------------------------");
        for (int i = 0; i < currentSize; i++) {
            System.out.printf("Test Score #%03d: %0.2f%n", i, scores[i]);
        }
        System.out.println("---------------------------");

  
}

       

    }
}
