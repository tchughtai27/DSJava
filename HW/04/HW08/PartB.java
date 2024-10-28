/*
 * Talha Chughtai HW08 PartB
 * 10/25
 */

import java.util.Scanner;

public class PartB {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the APR as a percent: ");
        double apr = in.nextDouble();
        System.out.println("Enter balance: ");
        double balance = in.nextDouble();

        double rate = apr / 100;

        System.out.println("Year |        Int Earned ($)       |           Balance ($)");
        System.out.println("----------------------------------------------------------------------");

        for (int year = 1; year <= 5; year++) {
            double interest = balance * rate;
            balance += interest;

            System.out.printf("%4d  | %23.2f | %25.2f%n", year, interest, balance);
        }

    }
}
