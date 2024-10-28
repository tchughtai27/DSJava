/*
 * Talha Chughtai HW08 PartA
 * 10/25
 */

public class PartA {
    public static void main(String[] args) {
        double initial = 100.0;
        double current = initial;
        int years = 0;

        while (current > 1.0) {
            current /= 2; //halve every thirty years
            years += 30; //increment the year by thirty

        }

        System.out.println("Years required: " + years);
        System.out.printf("Amount of material leftover: %.2f%%", current);




    }
}