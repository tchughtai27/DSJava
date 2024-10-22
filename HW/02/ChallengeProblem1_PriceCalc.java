/*
 * Challenge 1/3 Unit 02 AT3
 * Talha Chughtai
 * AT CS
 * 10/19 
 */





import java.util.Scanner;

public class ChallengeProblem1_PriceCalc {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //prompt price
        System.out.print("Enter the price in dolars and cents: ");
        double price = in.nextDouble();
        
        //calc dollars and cents
        int dollars = (int) price;
        int cents = (int) Math.round((price-dollars) * 100);

        System.err.printf("You have %d dollars and %d cents.%n ", dollars, cents);

        in.close();

    }
}